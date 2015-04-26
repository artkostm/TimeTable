package by.artkostm.androidparsers.core.util;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;

/**
 * Created by Artsiom on 26.04.2015.
 */
public class AndroidDexUtil {

    private AndroidDexUtil(){
    }

    private static Field dexField;

    static {
        try {
            dexField = PathClassLoader.class.getDeclaredField("mDexs");
            dexField.setAccessible(true);
        } catch (Exception e) {
            // TODO (1): handle this case gracefully - nobody promised that this field will always be there
            Log.e("DOMXML", "Failed to get mDexs field");
        }
    }

    public static void getAnnotaitedWith(Class<? extends Annotation> annotationCls, String pkg) {
        try {
            // TODO (2): check here - in theory, the class loader is not required to be a PathClassLoader
            PathClassLoader classLoader = (PathClassLoader) Thread.currentThread().getContextClassLoader();
            DexFile[] dexs = (DexFile[]) dexField.get(classLoader);
            for (DexFile dex : dexs) {
                Enumeration<String> entries = dex.entries();
                while (entries.hasMoreElements()) {
                    // (3) Each entry is a class name, like "foo.bar.MyClass"
                    String entry = entries.nextElement();
                    Log.d("DOMXML", "Entry: " + entry);

                    // (4) Load the class
                    Class<?> entryClass = dex.loadClass(entry, classLoader);
                    if (entryClass != null) {
                        Annotation annotation = entryClass.getAnnotation(annotationCls);
                        if (annotation != null) {
                            Log.d("DOMXML", entry + " found ");
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO (5): more precise error handling
            Log.e("DOMXML", "Error", e);
        }
    }

    private static class DexClasses{
        private static Set<Class<?>> dexs = new HashSet<>();

        private static void registerClass(Class<?> clazz){
            dexs.add(clazz);
        }

        private static Set<Class<?>> getRegistered(){
            return dexs;
        }
    }

    public static void register(Class<?> clazz){
        DexClasses.registerClass(clazz);
    }

    public static Set<Class<?>> registered(){
        return DexClasses.getRegistered();
    }
}
