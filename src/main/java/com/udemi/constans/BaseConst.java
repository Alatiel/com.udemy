package com.udemi.constans;

import java.util.Arrays;
import java.util.List;

public interface BaseConst {

    List<String> EXPECTED_HOMEPAGE_CATEGORIES = Arrays.asList("Development", "Business", "Finance & Accounting",
            "IT & Software", "Office Productivity", "Personal Development", "Design", "Marketing",
            "Lifestyle", "Photography", "Health & Fitness", "Music", "Teaching & Academics");

    String BASE_URL = "https://www.udemy.com/";

    String SEARCH_VALUE = "angular";
    String WRONG_SEARCH_VALUE = "PHP";

    String URL_ROUT = "ref=home";
}
