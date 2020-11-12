package model;

import IO.SerializerDeserializerIO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class testSerializerDeserializerIO {

    @Test
    public void weapondeserealizjson(){
        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();
        Weapon sreyrMann1 = new Weapon.Builder()
                .withType(Weapon.Type.FIREARM)
                .withName("Steyr-Mannlicher STM-556")
                .withDamages(86)
                .withLevel(30)
                .withCost(9700)
                .withLocation(yordan)
                .build();
        Weapon weapon1 = new Weapon();
        SerializerDeserializerIO ds = new SerializerDeserializerIO();
        weapon1 = ds.deserializejson(weapon1, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_1.json");
        assertEquals(weapon1, sreyrMann1);
    }


    @Test
    public void locationdeserealizjson(){
        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();

        Location yordanSecond = new Location();
        SerializerDeserializerIO ds = new SerializerDeserializerIO();
        yordanSecond = ds.deserializejson(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/location_1.json");
        assertEquals(yordan, yordanSecond);
    }

    @Test
    public void weapondeserealizxml(){
        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();
        Weapon sreyrMann1 = new Weapon.Builder()
                .withType(Weapon.Type.FIREARM)
                .withName("Steyr-Mannlicher STM-556")
                .withDamages(86)
                .withLevel(30)
                .withCost(9700)
                .withLocation(yordan)
                .build();
        Weapon weapon1 = new Weapon();
        SerializerDeserializerIO ds = new SerializerDeserializerIO();
        weapon1 = ds.deserializexml(weapon1, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_1.xml");
        assertEquals(weapon1, sreyrMann1);
    }


    @Test
    public void locationdeserealizxml(){
        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();

        Location yordanSecond = new Location();
        SerializerDeserializerIO ds = new SerializerDeserializerIO();
        yordanSecond = ds.deserializexml(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/location_1.xml");
        assertEquals(yordan, yordanSecond);
    }


    @Test
    public void weapondeserealiztxt(){
        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();
        Weapon sreyrMann1 = new Weapon.Builder()
                .withType(Weapon.Type.FIREARM)
                .withName("Steyr-Mannlicher STM-556")
                .withDamages(86)
                .withLevel(30)
                .withCost(9700)
                .withLocation(yordan)
                .build();
        Weapon weapon1 = new Weapon();
        SerializerDeserializerIO ds = new SerializerDeserializerIO();
        weapon1 = ds.deserializetxt(weapon1, "D:/THIRDCLS/Java/labs/lab2/testout/weapon_1.txt");
        assertEquals(weapon1, sreyrMann1);
    }


    @Test
    public void locationdeserealiztxt(){
        Location yordan = new Location.Builder()
                .withKingdom("Yordan")
                .withMainRace(Location.Race.WITCHES)
                .withEnteringLevel(23)
                .withPartName("Ice Prisone")
                .build();

        Location yordanSecond = new Location();
        SerializerDeserializerIO ds = new SerializerDeserializerIO();
        yordanSecond = ds.deserializetxt(yordanSecond, "D:/THIRDCLS/Java/labs/lab2/testout/location_1.txt");
        assertEquals(yordan, yordanSecond);
    }


}
