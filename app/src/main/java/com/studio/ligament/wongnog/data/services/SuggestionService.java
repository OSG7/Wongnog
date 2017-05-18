package com.studio.ligament.wongnog.data.services;

import android.text.TextUtils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class SuggestionService {
    private static final List<String> DUMMY = new ArrayList<String>() {{
        add("ก๋ยวเตี๋ยว");
        add("ไก่อบ");
        add("ไข่เจียว");
        add("ผัดไทยไข่เจียวกุ้งสด");
        add("น้อยมาก");
        add("ข้าวลาบ");
        add("น้ำตกเนื่อเปื่อย");
        add("ก๋วยเตี๋ยวไข่");
        add("กระะเพราหมูสับ");
        add("กระเพราหมูกรอบ");
        add("แจ๋วฮ้อน");
        add("ปังเย็น");
        add("เส้นใหญ่เย็นตาโฟ");
    }};

    public Observable<List<String>> get(String query) {
        if (TextUtils.isEmpty(query)) {
            return Observable.just(new ArrayList<>());
        }

        List<String> suggestions = new ArrayList<>();
        int count = new SecureRandom().nextInt(DUMMY.size() - 1) + 1;
        for (int i = 0; i < count; i++) {
            suggestions.add(DUMMY.get(new SecureRandom().nextInt(DUMMY.size())));
        }
        return Observable.just(suggestions);
    }
}
