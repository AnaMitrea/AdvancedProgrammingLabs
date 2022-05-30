package bonus.customcompiler;

import javax.tools.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CompileClass {
    /**
     * Compiles a given .java file
     * @param path  Class path
     * @return  succeeded or not
     */
    public static boolean compile(String path) {
        File file = new File(path);

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> ds = new DiagnosticCollector<>();

        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(ds, null, null);

        Iterable<? extends JavaFileObject> compilationUnit = fileManager.getJavaFileObjects(file);

        List<String> optionList = new ArrayList<>();
        optionList.add("-classpath");
        optionList.add(System.getProperty("java.class.path") + File.pathSeparator + "dist/InlineCompiler.jar");

        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, ds, optionList, null, compilationUnit);

        return task.call();
    }
}
