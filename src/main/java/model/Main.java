package model;

import IO.SerializerDeserializerIO;


public class Main {
    public static void main(String[] args) {
        Weapon swoard = new Weapon.Builder()
                .withType(Weapon.Type.BLADED)
                .withLevel(3)
                .build();


        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();

        Location yordanSecond = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();


        Location middleLine = new Location();
        middleLine.setPartName("Middle Line");
        Location maddleLineB = new Location.Builder()
                .withPartName("Middle Line")
                .build();

        Location lowLine = new Location();
        lowLine.setPartName("Low Line");
        Location lowLineB = new Location.Builder()
                .withPartName("Low Line")
                .build();


        Weapon sreyrMann1 = new Weapon.Builder()
                .withType(Weapon.Type.FIREARM)
                .withName("Steyr-Mannlicher STM-556")
                .withDamages(86)
                .withLevel(30)
                .withCost(9700)
                .withLocation(yordan)
                .build();

        Weapon sreyrMann2 = new Weapon.Builder()
                .withType(Weapon.Type.FIREARM)
                .withName("Steyr-Mannlicher SSG-08")
                .withDamages(202)
                .withLevel(45)
                .withCost(30000)
                .withLocation(yordan)
                .build();

        SerializerDeserializerIO ps = new SerializerDeserializerIO();

        /*---------------  JSON WEAPON ---------------*/

        ps.serializejson(sreyrMann1, "D:/THIRDCLS/Java/labs/lab2/testout/");
        ps.serializejson(sreyrMann2, "D:/THIRDCLS/Java/labs/lab2/testout/");


        System.out.println(ps.deserializejson(swoard, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_"
                + ps.getMaxWeaponJSON() + ".json").toString());

        System.out.println(ps.deserializejson(swoard, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_"
                        + (ps.getMaxWeaponJSON()+1)+ ".json").toString());

        //---------------  JSON LOCATION---------------

        ps.serializejson(yordan, "D:/THIRDCLS/Java/labs/lab2/testout/");
        ps.serializejson(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/");


        System.out.println(ps.deserializejson(yordan, "D:/THIRDCLS/Java/labs/lab2/testout/location_"
                + ps.getMaxLocationJSON()+ ".json").toString());

        System.out.println(ps.deserializejson(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/location_"
                + (ps.getMaxLocationJSON()+1)+ ".json").toString());

        //---------------  XML WEAPON ---------------

        ps.serializexml(sreyrMann1, "D:/THIRDCLS/Java/labs/lab2/testout/");
        ps.serializexml(sreyrMann2, "D:/THIRDCLS/Java/labs/lab2/testout/");

        System.out.println(ps.deserializexml(sreyrMann1, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_"
                + ps.getMaxWeaponXML() + ".xml").toString());

        System.out.println(ps.deserializexml(sreyrMann2, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_"
                + (ps.getMaxWeaponXML()+1)+ ".xml").toString());

        //---------------  XML LOCATION---------------

        ps.serializexml(yordan, "D:/THIRDCLS/Java/labs/lab2/testout/");
        ps.serializexml(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/");


        System.out.println(ps.deserializexml(yordan, "D:/THIRDCLS/Java/labs/lab2/testout/location_"
                + ps.getMaxLocationXML()+ ".xml").toString());

        System.out.println(ps.deserializexml(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/location_"
                + (ps.getMaxLocationXML()+1)+ ".xml").toString());


        //---------------  TXT WEAPON ---------------

        ps.serializetxt(sreyrMann1, "D:/THIRDCLS/Java/labs/lab2/testout/");
        ps.serializetxt(sreyrMann2, "D:/THIRDCLS/Java/labs/lab2/testout/");

        System.out.println(ps.deserializetxt(sreyrMann1, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_"
                + ps.getMaxWeaponTXT() + ".txt").toString());

        System.out.println(ps.deserializetxt(sreyrMann2, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_"
                + (ps.getMaxWeaponTXT()+1)+ ".txt").toString());

        //---------------  TXT LOCATION---------------

        ps.serializetxt(yordan, "D:/THIRDCLS/Java/labs/lab2/testout/");
        ps.serializetxt(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/");


        System.out.println(ps.deserializetxt(yordan, "D:/THIRDCLS/Java/labs/lab2/testout/location_"
                + ps.getMaxLocationTXT()+ ".txt").toString());

        System.out.println(ps.deserializetxt(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/location_"
                + (ps.getMaxLocationTXT()+1)+ ".txt").toString());

    }
}

