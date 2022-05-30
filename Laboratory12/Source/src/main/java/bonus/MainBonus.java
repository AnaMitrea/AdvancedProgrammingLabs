package bonus;
import bonus.customcompiler.CompileClass;
import bonus.util.LoadAndExecute;
import java.lang.reflect.InvocationTargetException;

public class MainBonus {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        String path = "C:\\Users\\Ana\\Documents\\GitHub\\PA\\Laboratorul12\\Source\\src\\main\\java\\GlobalTestBonus.java";

        if(CompileClass.compile(path)) {
            System.out.println("File Compiled!");
        }
        LoadAndExecute loadAndExecute = new LoadAndExecute("", "GlobalTestBonus");
        loadAndExecute.execute();
    }
}
