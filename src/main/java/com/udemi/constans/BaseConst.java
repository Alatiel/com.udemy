package com.udemi.constans;

import java.util.Arrays;
import java.util.List;

public interface BaseConst {

    String BASE_URL = "https://www.udemy.com/";

    List<String> EXPECTED_HOMEPAGE_CATEGORIES = Arrays.asList("Development", "Business", "Finance & Accounting",
            "IT & Software", "Office Productivity", "Personal Development", "Design", "Marketing",
            "Lifestyle", "Photography", "Health & Fitness", "Music", "Teaching & Academics");

    //constants for search test
    String SEARCH_VALUE = "angular";
    String WRONG_SEARCH_VALUE = "PHP";
    String SEARCH_RESULT_TITLE= "Angular";

    String URL_ROUT = "ref=home";
}
