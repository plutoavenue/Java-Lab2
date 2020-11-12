package IO;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Location;
import model.Weapon;

import java.io.*;
import java.util.Random;


public class SerializerDeserializerIO {


    private static int maxWeaponJSON=0;
    private static int maxLocationJSON =0;
    private static int maxWeaponXML=0;
    private static int maxLocationXML =0;
    private static int maxWeaponTXT=0;
    private static int maxLocationTXT=0;

    public static int getMaxWeaponJSON() {
        return maxWeaponJSON;
    }

    public static int getMaxLocationJSON() {
        return maxLocationJSON;
    }

    public static int getMaxWeaponXML() {
        return maxWeaponXML;
    }

    public static int getMaxLocationXML() {
        return maxLocationXML;
    }

    public static int getMaxWeaponTXT() {
        return maxWeaponTXT;
    }

    public static int getMaxLocationTXT() {
        return maxLocationTXT;
    }


    public SerializerDeserializerIO() {
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }


    /*---------------  JSON ---------------*/


    public <T> void serializejson(T obj, String pathToRoot) {

        int max=0;

        File folder = new File(pathToRoot);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".json") &&
                    listOfFiles[i].getName().contains(obj.getClass().getSimpleName().toLowerCase())) {
                String fn = listOfFiles[i].getName().replace(".json", "");
                max = Math.max(Integer.parseInt(fn.split("_")[1]), max);
            }
        }

        if(obj.getClass().getSimpleName().toLowerCase().equals("weapon")) maxWeaponJSON=max;
        else maxLocationJSON = max;
        String pathway = pathToRoot + obj.getClass().getSimpleName().toLowerCase() + "_" + (max+1) + ".json";
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file = new File(pathway);
        try {
            file.createNewFile();
            mapper.writeValue(file, obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Weapon deserializejson(Weapon obj, String pathToFile) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file = new File(pathToFile);
        try {
            if (pathToFile.isEmpty())
                throw new RuntimeException("File doesnt exist");
            Weapon newObj = mapper.readValue(file, Weapon.class);
            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("null");
        }

    }

    public Location deserializejson(Location obj, String pathToFile) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File file = new File(pathToFile);
        try {
            if (pathToFile.isEmpty())
                return null;
            Location newObj = mapper.readValue(file, Location.class);
            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }


    /*---------------  XML ---------------*/

    public <T> void serializexml(T obj, String pathToRoot) {

        int max=0;

        File folder = new File(pathToRoot);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".xml") &&
                    listOfFiles[i].getName().contains(obj.getClass().getSimpleName().toLowerCase())) {
                String fn = listOfFiles[i].getName().replace(".xml", "");
                max = Math.max(Integer.parseInt(fn.split("_")[1]), max);
            }
        }

        if(obj.getClass().getSimpleName().toLowerCase().equals("weapon")) maxWeaponXML=max;
        else maxLocationXML = max;
        String pathway = pathToRoot + obj.getClass().getSimpleName().toLowerCase() + "_" + (max+1) +  ".xml";
        try{
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            xmlMapper.writeValue(new File(pathway), obj);
            File file = new File(pathway);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Weapon deserializexml(Weapon obj, String pathToFile)  {
        if (pathToFile.isEmpty())
            return obj;
        try {
            File file = new File(pathToFile);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            String xml = inputStreamToString(new FileInputStream(file));
            return xmlMapper.readValue(xml, Weapon.class);
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    public Location deserializexml(Location obj, String pathToFile) {
        if (pathToFile.isEmpty())
            return obj;
        try {
            File file = new File(pathToFile);
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            String xml = inputStreamToString(new FileInputStream(file));
            Location newObj = xmlMapper.readValue(xml, Location.class);
            return newObj;
        } catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

    /*---------------  TXT ---------------*/


    public <T> void serializetxt(T obj, String pathToRoot){
        int max=0;

        File folder = new File(pathToRoot);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".txt") &&
                    listOfFiles[i].getName().contains(obj.getClass().getSimpleName().toLowerCase())) {
                String fn = listOfFiles[i].getName().replace(".txt", "");
                max = Math.max(Integer.parseInt(fn.split("_")[1]), max);
            }
        }

        if(obj.getClass().getSimpleName().toLowerCase().equals("weapon")) maxWeaponTXT=max;
        else maxLocationTXT = max;
        String pathway = pathToRoot + obj.getClass().getSimpleName().toLowerCase() + "_" + (max+1) + ".txt";
        try
        {
            File file = new File(pathway);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(obj.toString());
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Weapon deserializetxt(Weapon obj, String pathToFile) {
        try {
            if (pathToFile.isEmpty())
                return obj;
            InputStream oi = new FileInputStream(new File(pathToFile));
            String strobj = inputStreamToString(oi);
            obj = obj.fromString(strobj);
            oi.close();
            return obj;
        }
        catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }


    public Location deserializetxt(Location obj, String pathToFile)  {
        try {
            if (pathToFile.isEmpty())
                return obj;
            InputStream oi = new FileInputStream(new File(pathToFile));
            String strobj = inputStreamToString(oi);
            obj = obj.fromString(strobj);
            oi.close();
            return obj;
        }
        catch (IOException e) {
            e.printStackTrace();
            return obj;
        }
    }

}

