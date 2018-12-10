package com.dimakl.java


import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ErrorNode
import java.util.*
import kotlin.math.*

//Get list of string representations of functions
class FormulaAnalyzer(function: MutableList<String>, val dataProc : JsonDataProcessor) : BaseVisitor<Double?>() {

    private val parserRootCtx = mutableListOf<GenParser.RootContext>()
    private val rootCtxHashMap = mutableMapOf<String, GenParser.RootContext>()
    init {
        function.forEach {parserRootCtx.add(GenParser(CommonTokenStream(GenLexer(CharStreams.fromString(it)))).root())}
        parserRootCtx.forEach { rootCtxHashMap[it.variable().ID().toString()] = it}
    }
    private var variables = mutableMapOf<String, Double>()
    private val functions = hashMapOf<String,(List<Double>)-> Double>(
        "sin" to {i -> sin(i[0])},
        "cos" to {i -> cos(i[0])},
        "tan" to {i -> tan(i[0])},
        "cot" to {i -> 1 / tan(i[0])},
        "sqrt" to {i -> sqrt(i[0])},
        "abs" to {i -> abs(i[0])},
        "min" to {i -> min(i[0], i[1])},
        "max" to {i -> max(i[0], i[1])},
        "log" to {i -> log(i[0], i[1])},
        "log2" to {i -> log(i[0], 2.0)},
        "log10" to {i -> log(i[0], 10.0)},
        "ceil" to {i -> ceil(i[0])},
        "floor" to {i -> floor(i[0])},
        "randInt" to { _ -> Random().nextDouble()},
        "randTo" to {arr -> Random().nextInt() % arr[0]}
    )

    private val errors = mutableListOf<String>()


    //It's need for calculating value
    //parameters:
    //hashMap - map of pairs (name_of_variable, its_value)
    //v - variable that we need to calculate
    fun run(hashMap: MutableMap<String, Double>, v : String): String? {
        errors.clear()
        this.variables = hashMap
        return try {
            visitRoot(rootCtxHashMap[v])?.toString() ?: errorsToString()
        } catch (e : Exception) {
            errors.add(0,"Error: Wrong input.")
            Log.e("PRS", "Wrong input")
            errorsToString()
        }
    }

    override fun visitVariable(ctx: GenParser.VariableContext?) : Double?{
        val name = ctx?.ID()?.text
        return variables[name]
    }

    override fun visitExpr(ctx: GenParser.ExprContext?): Double? {
        if (ctx == null)
            return null
        if (ctx.childCount == 1) {
            when {
                ctx.variable() != null -> return visitVariable(ctx.variable())
                ctx.con() != null -> return visitCon(ctx.con())
                ctx.NUMBER() != null -> return ctx.NUMBER().text.toDoubleOrNull()
            }
        }
        if (ctx.childCount == 2) {
            when {
                ctx.MINUS() != null -> {
                    val res = visitExpr(ctx.expr(0))
                    return if (res != null) -res else null
                }
            }
        }
        if (ctx.childCount == 3) {
            if (ctx.LBR() != null)
                return visitExpr(ctx.expr(0))
            val a = visitExpr(ctx.expr(0))
            val b = visitExpr(ctx.expr(1))
            if (a == null || b == null)
                return null
            when {
                ctx.PLUS() != null -> return a + b
                ctx.MINUS() != null -> return a - b
                ctx.DIV() != null -> {
                    return if (b != 0.0)
                        a / b
                    else {
                        errors.add("Error: Divide by zero.")
                        Log.e("PRS", "Divide by zero")
                        null
                    }

                }
                ctx.MULT() != null -> return a * b
                ctx.CAP() != null -> return a.pow(b)
            }
        }
        if (ctx.func() != null) {
            if (!functions.containsKey(ctx.func().ID().toString())) {
                errors.add("Error: Function ${ctx.func().ID()} doesn't exist.")
                Log.e("PRS", "Function ${ctx.func().ID()} doesn't exist.")
                return null
            }
            val args = mutableListOf<Double>()
            ctx.expr().forEach {args.add(visitExpr(it) ?: return null)}
            return try {
                functions[ctx.func().ID().toString()]?.invoke(args)
            } catch (e : ArithmeticException) {
                errors.add("Error: Arithmetic exception in function.")
                Log.e("PRS", "Arithmetic exception")
                null
            }
        }
        return null
    }

    override fun visitErrorNode(node: ErrorNode?): Double? {
        errors.add("Error: Wrong input.")
        Log.e("PRS", "Wrong input")
        return super.visitErrorNode(node)
    }

    override fun visitCon(ctx: GenParser.ConContext?): Double? {
        val tmp = dataProc.getConstValue(ctx?.ID().toString())
        if (tmp == null) {
            errors.add("Error: Constant doesn't exist.")
            Log.e("PRS", "Constant doesn't exist.")
        }
        return tmp
    }

    private fun errorsToString() : String{
        var res = ""
        errors.map { res += "$it\n" }
        return res
    }
}