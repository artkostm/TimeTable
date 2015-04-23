package by.artkostm.androidparsers.core.enhancer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import by.artkostm.androidparsers.core.builders.Builder;
import by.artkostm.androidparsers.core.builders.PropsObjectBuilder;

public class PropertyEnhancer implements Enhancer{
    
    private Class<?> type;
    
    public PropertyEnhancer(Class<?> type) {
        this.type = type;
    }

    @Override
    public Object enhance(Object source) {
        List<String> props = getProps(source);
        Builder<?> builder = new PropsObjectBuilder<>(type);
        Object obj = builder.build(props);
        return obj;
    }

    private void buildReader(Object source, BufferedReader reader){
        if(source instanceof InputStream){
            reader = new BufferedReader(new InputStreamReader((InputStream)source));
        }else{
            try{
                reader = new BufferedReader(new FileReader((File)source));
            }catch (FileNotFoundException e){
                throw new RuntimeException("Can't read a file");
            }
        }
    }
    
    private List<String> getProps(Object src){
        BufferedReader br = null;
        buildReader(src, br);
        List<String> source = new ArrayList<>();
        try{
            String str = null;
            while((str = br.readLine()) != null){
                if(!str.trim().isEmpty()){
                    source.add(str);
                }
            }
        } catch (IOException e1) {
            throw new RuntimeException("Can't read a file");
        }finally{
            if(br != null){
                try{br.close();}catch(Exception e){}
            }
        }
        return source;
    }
}
