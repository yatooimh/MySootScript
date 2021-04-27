package Basic;

import Config.SootConfig;
import soot.*;
import soot.jimple.JimpleBody;
import soot.util.Chain;

/**
 * @program: MySootScript
 * @description:
 * @author: 0range
 * @create: 2021-04-27 10:21
 **/


public class ParseMethodBody {

    private static String className = "Demo.Circle";

    private static final String methodSubSignature = "int area(boolean)";

    public static void main(String[] args) {
        SootConfig.setupSoot(className);
        getMethodBodyInfo();
    }

    private static void getMethodBodyInfo() {

        SootClass sc = Scene.v().getSootClass(className);
        SootMethod areaMethod = sc.getMethod(methodSubSignature);

        //获得方法体
        JimpleBody areaBody = (JimpleBody)areaMethod.retrieveActiveBody();

        //局部变量数量
        int localCount = areaBody.getLocalCount();

        Chain<Local> locals = areaBody.getLocals();

        //jimple stmt
        UnitPatchingChain units = areaBody.getUnits();


        //捕获异常
        Chain<Trap> traps = areaBody.getTraps();

        //获取this变量+引用类型+第一个局部变量z0
        Local thisLocal = areaBody.getThisLocal();
        Type thisType = thisLocal.getType();
        Local paramLocal = areaBody.getParameterLocal(0);


        System.out.print("[class name] = " + sc.getName() +'\n'
                +"[method name] = " + areaMethod.getName() + '\n'
                +"[method signature] = " + areaMethod.getSignature() + '\n'
                +"[method signature] = " + areaMethod.getSubSignature() + '\n'
                +"--------------------------------------"+'\n'
                +"[locals count] = " + localCount + '\n'
                +"[local  list] = " + locals + '\n'
                +"--------------------------------------"+'\n'
                +"[unit list] = " + units + '\n'
                +"--------------------------------------"+'\n'
                +"[exception] = " + traps + '\n'
                +"--------------------------------------"+'\n'
                +"[this] = " + thisLocal + '\n'
                +"[this type] = " + thisType + '\n'
                +"[0th local] = " + paramLocal + '\n'
        );

    }

}
