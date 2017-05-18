package com.studio.ligament.wongnog.data.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@AutoValue
public abstract class Recipe extends Model {

    public static final Recipe dummy0 = new AutoValue_Recipe(
            "ก๋วยเตี๋ยวนำชัยประตู4",
            " ที่จอดรถ: ปานกลาง\n" +
                    " ราคา: 35-45 บาท\n" +
                    " เบอร์ร้าน: ไม่มี\n" +
                    " เมนูแนะนำ: เส้นใหญ่เย็นตาโฟ\n" +
                    " เวลา: 14.00-00.00 น.\n" +
                    " ไวไฟ: ไม่มี\n",
            "https://firebasestorage.googleapis.com/v0/b/wongnog-2c9b9.appspot.com/o/18596786_1379306195448329_284703067_o.jpg?alt=media&token=33e84dc6-c8e2-45f3-a541-29afc7f0a6d5",
            16.746269, 100.202677,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy1 = new AutoValue_Recipe(
            "ครัวปิยะวรรณ",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 30 - 59 บาท\n" +
                    " เบอร์ร้าน: 093-1379145\n" +
                    " เมนูแนะนำ: กระเพราไข่เยี่ยวม้า\n" +
                    " เวลา: 16.00 - 23.00 น.\n" +
                    " ไวไฟ: มี\n",
            "https://firebasestorage.googleapis.com/v0/b/wongnog-2c9b9.appspot.com/o/18552747_1379306495448299_738243559_o.jpg?alt=media&token=7c530f67-d4c7-4385-b4e7-5d586d9ee911",
            16.746578, 100.203215,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy2 = new AutoValue_Recipe(
            "ถุงนม",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 10-35 บาท\n" +
                    " เบอร์ร้าน: 090-9641404\n" +
                    " เมนูแนะนำ: ปังเย็น\n" +
                    " เวลา: 18.00-00.00  น.\n" +
                    " ไวไฟ: ไม่มี\n",
            "https://firebasestorage.googleapis.com/v0/b/wongnog-2c9b9.appspot.com/o/18552879_1379306585448290_2004121466_o.jpg?alt=media&token=8bcda699-6df1-4820-af9c-e3c08e6718ab",
            16.746560, 100.203532,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy3 = new AutoValue_Recipe(
            "ต๋องแจ๋วฮ้อน 99",
            " ที่จอดรถ: ปานกลาง\n" +
                    " ราคา: 99 บาท\n" +
                    " เบอร์ร้าน: 091-9725433\n" +
                    " เมนูแนะนำ: แจ๋วฮ้อน\n" +
                    " เวลา: 17.00-22.00 น.\n" +
                    " ไวไฟ: มี\n",
            "https://firebasestorage.googleapis.com/v0/b/wongnog-2c9b9.appspot.com/o/18552782_1379306712114944_1795185915_o.jpg?alt=media&token=c03e8830-324b-4b4f-b547-204ec3aaabd5",
            16.746560, 100.203532,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy4 = new AutoValue_Recipe(
            "ป้ากรไก่อบโค้ก",
            " ที่จอดรถ: มีเล็กน้อย\n" +
                    " ราคา: 35 - 55 บาท\n" +
                    " เบอร์ร้าน: ไม่มี\n" +
                    " เมนูแนะนำ: ข้าวไก่อบโค้ก - ข้าวแจ่วเอ็นไก่\n" +
                    " เวลา: 12.00 - 23.00 น.\n" +
                    " ไวไฟ: ไม่มี\n",
            "https://firebasestorage.googleapis.com/v0/b/wongnog-2c9b9.appspot.com/o/18596257_1379306822114933_264892663_o.jpg?alt=media&token=4b73485e-6dec-4f57-9ac3-d1d73ec6a6f7",
            16.747112, 100.204406,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy5 = new AutoValue_Recipe(
            "ร้านก๋วยเตี๋ยวพี่นก",
            " ทที่จอดรถ: น้อยมาก\n" +
                    " ราคา: 35 - 100 บาท \n" +
                    " เบอร์ร้าน: 093-2966961\n" +
                    " เมนูแนะนำ: ข้าวลาบ - ก๋วยเตี๋ยวแซบแห้ง\n" +
                    " เวลา: 16.30 - 00.30 น.\n" +
                    " ไวไฟ: ไม่มี\n",
            "https://firebasestorage.googleapis.com/v0/b/wongnog-2c9b9.appspot.com/o/18519314_1379306252114990_62260227_o.jpg?alt=media&token=9890cb05-b879-40bb-878d-6a7d88dc52e9",
            16.747112, 100.204406,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy6 = new AutoValue_Recipe(
            "ร้านข้าวผัด",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 30 - 45\n" +
                    " เบอร์ร้าน: 088 148 3878\n" +
                    " เมนูแนะนำ: กระเพราหมูกรอบ\n" +
                    " เวลา: 7.00-21.30 \n" +
                    " ไวไฟ: ไม่มี\n",
            "https://img-global.cpcdn.com/001_recipes/2432172_ca45a86ea8fa754b/640x640sq70/photo.jpg",
            16.747112, 100.204406,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy7 = new AutoValue_Recipe(
            "ร้านป้าอาจ",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 30 - 60 บาท\n" +
                    " เบอร์ร้าน: 091-8505239\n" +
                    " เมนูแนะนำ: กระะเพราหมูสับ\n" +
                    " เวลา: 11.00-22.00 น.\n" +
                    " ไวไฟ: มี\n",
            "https://img-global.cpcdn.com/001_recipes/2432172_ca45a86ea8fa754b/640x640sq70/photo.jpg",
            16.753477, 100.196417,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy8 = new AutoValue_Recipe(
            "ร้านลุงเชฟ ไข่เจียวลอยฟ้า",
            " ที่จอดรถ: ปานกลาง\n" +
                    " ราคา: 25-40\n" +
                    " เบอร์ร้าน: 095 490 5177\n" +
                    " เมนูแนะนำ: ไข่เจียวขยี\n" +
                    " เวลา: 16.00-1.00 น.\n" +
                    " ไวไฟ: ไม่มีn",
            "https://img-global.cpcdn.com/001_recipes/2432172_ca45a86ea8fa754b/640x640sq70/photo.jpg",
            16.753431, 100.196143,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy9 = new AutoValue_Recipe(
            "ร้านลูกชิ้นนายฮุย",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 30-60บาท\n" +
                    " เบอร์ร้าน: 02 418 2668\n" +
                    " เมนูแนะนำ: ก๋วยเตี๋ยวไข่\n" +
                    " เวลา: 16.00-1.00 น.\n" +
                    " ไวไฟ: มี\n",
            "https://img-global.cpcdn.com/001_recipes/2432172_ca45a86ea8fa754b/640x640sq70/photo.jpg",
            16.753547, 100.196226,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy10 = new AutoValue_Recipe(
            "ร้านแชมป์",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 30-60บาท\n" +
                    " เบอร์ร้าน: 02 932 71459\n" +
                    " เมนูแนะนำ: น้ำตกเนื่อเปื่อย\n" +
                    " เวลา: 17.00-00.00 น.\n" +
                    " ไวไฟ: ไม่มี\n",
            "https://img-global.cpcdn.com/001_recipes/2432172_ca45a86ea8fa754b/640x640sq70/photo.jpg",
            16.753519, 100.196196,
            "Updated at 15/05/2016",
            User.dummy());
    public static final Recipe dummy11 = new AutoValue_Recipe(
            "สถานีรสแจ่ม",
            " ที่จอดรถ: น้อย\n" +
                    " ราคา: 30-60 บาท\n" +
                    " เบอร์ร้าน: 086 552 2197\n" +
                    " เมนูแนะนำ: ผัดไทยไข่เจียวกุ้งสด\n" +
                    " เวลา: 16.00-22.00 น.\n" +
                    " ไวไฟ: ไม่มี\n",
            "https://img-global.cpcdn.com/001_recipes/2432172_ca45a86ea8fa754b/640x640sq70/photo.jpg",
            16.753314, 100.196067,
            "Updated at 15/05/2016",
            User.dummy());

    @JsonProperty("title")
    public abstract String title();

    @JsonProperty("description")
    public abstract String description();

    @JsonProperty("image_url")
    public abstract String imageUrl();

    @JsonProperty("lat")
    public abstract double lat();

    @JsonProperty("lng")
    public abstract double lng();

    @JsonProperty("updated_at")
    public abstract String updatedAt();

    @JsonProperty("user")
    public abstract User user();

    @JsonCreator
    public static Recipe create(@JsonProperty("title") String title,
                                @JsonProperty("description") String description,
                                @JsonProperty("image_url") String imageUrl,
                                @JsonProperty("lat") double lat,
                                @JsonProperty("lng") double lng,
                                @JsonProperty("updated_at") String updatedAt,
                                @JsonProperty("user") User user) {

        return new AutoValue_Recipe(title, description, imageUrl, lat, lng, updatedAt, user);
    }

    public static Recipe dummy() {
        int index = new SecureRandom().nextInt(3);
        switch (index) {
            case 0:
                return dummy0;
            case 1:
                return dummy1;
            default:
                return dummy2;
        }
    }

    public static List<Recipe> dummies() {
        return new ArrayList<Recipe>() {{
            add(Recipe.dummy0);
            add(Recipe.dummy1);
            add(Recipe.dummy2);
            add(Recipe.dummy3);
            add(Recipe.dummy4);
            add(Recipe.dummy5);
            add(Recipe.dummy6);
            add(Recipe.dummy7);
            add(Recipe.dummy8);
            add(Recipe.dummy9);
            add(Recipe.dummy10);
            add(Recipe.dummy11);
        }};
    }
}
