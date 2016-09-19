package com.shun.blog.commons.authentification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.springframework.ui.ModelMap;

public interface CommonFnDAO {

	void setCountingListPages(int limit_count, int count_tmp, ModelMap model, int page);

	String checkVDQuestion(String question);

	int setToInt(String input);

	int checkVDInt(String parameter, int default_value);

	float checkVDFloat(String parameter, int default_value);

	String setTitleName(ArrayList<String> final_parameters, String title_link, String location_name);

	Properties getLanguageText(String language_code, Properties text_ko, Properties text_en, Properties text_ja);

	int getTotalPage(int count_tmp, int limit_count);

	ArrayList<String> collectParameters(ArrayList<String> target_names);

	int counting_table(List<Integer> tableOrder);

	ArrayList<String> getCollectionValues(List<List<String>> rawData);

	String getPrincipal();

	Properties getTextProperties(String language_code, Properties text_ko, Properties text_en, Properties text_ja);

	String Get_DateInfo(Date date);

}
