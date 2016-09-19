package com.shun.blog.commons.authentification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

@Repository
public class CommonFnDAOService implements CommonFnDAO {

	private String set_textlenth(String text, int count) {
		String content_text = text;
		if (content_text.length() > count) {
			content_text = text.substring(0, count);
		}
		return content_text;
	}

	private String set_contentlenth(String content) {
		String content_text = content.replaceAll("<br>", " ").replaceAll("<p>", " ").replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
		return content_text;
	}

	@Override
	public String Get_DateInfo(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str2 = df.format(date);
		return str2;
	}

	@Override
	public ArrayList<String> collectParameters(ArrayList<String> target_names) {
		ArrayList<String> final_parameters = new ArrayList<String>();

		for (int i = 0; i < target_names.size(); i++) {
			String category_name = target_names.get(i);
			if (category_name != null) {
				final_parameters.add(category_name);
			}
		}

		return final_parameters;
	}

	@Override
	public Properties getTextProperties(String language_code, Properties text_ko, Properties text_en, Properties text_ja) {
		// 언어 설정 선택
		Properties text = getLanguageText(language_code, text_ko, text_en, text_ja);
		return text;
	}

	@Override
	public String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@Override
	public void setCountingListPages(int limit_count, int count_tmp, ModelMap model, int page) {
		int total_page = getTotalPage(count_tmp, limit_count);
		int adding_value = setCoutingPage_start(page, total_page);
		int adding_value_end = setCoutingPage_end(page, total_page);

		model.addAttribute("adding_value", adding_value);
		model.addAttribute("adding_value_end", adding_value_end);
		model.addAttribute("total_page", total_page);
		model.addAttribute("page", page);
	}

	@Override
	public String checkVDQuestion(String question) {
		String question_text = "";
		try {
			if (question.length() > 0) {
				question_text = "\"" + question.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "").replaceAll("[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]", "%").trim() + "\"";
			} else {
				question_text = null;
			}
		} catch (Exception e) {
			question_text = null;
		}
		return question_text;
	}

	@Override
	public int setToInt(String input) {
		int value;
		value = Integer.parseInt(input);
		return value;
	}

	@Override
	public int checkVDInt(String parameter, int default_value) {
		int int_value;
		try {
			int_value = Integer.parseInt(parameter);
		} catch (Exception e) {
			int_value = default_value;
		}
		return int_value;
	}

	@Override
	public float checkVDFloat(String parameter, int default_value) {
		float int_value;
		try {
			int_value = Float.parseFloat(parameter);
		} catch (Exception e) {
			int_value = default_value;
		}
		return int_value;
	}

	@Override
	public String setTitleName(ArrayList<String> final_parameters, String title_link, String location_name) {
		String title_name = "";

		if (final_parameters.size() > 0) {
			for (int i = 0; i < final_parameters.size(); i++) {
				String remove_words = final_parameters.get(i).replace("\"", "");
				title_name += remove_words + title_link;
			}
		}

		title_name += location_name;
		String remove_words = title_name.replace("|  |", "|");

		return remove_words;
	}

	@Override
	public Properties getLanguageText(String language_code, Properties text_ko, Properties text_en, Properties text_ja) {
		Properties text = text_ko;
		if (language_code.equals("en")) {
			text = text_en;
		} else if (language_code.equals("ko")) {
			text = text_ko;
		} else if (language_code.equals("ja")) {
			text = text_ja;
		}
		return text;
	}

	@Override
	public int getTotalPage(int count_tmp, int limit_count) {
		int total_page;

		if (count_tmp <= limit_count) {
			total_page = 1;
		} else {
			if (count_tmp % limit_count == 0) {
				total_page = (int) Math.ceil(count_tmp / limit_count);

			} else {
				total_page = (int) Math.ceil(count_tmp / limit_count) + 1;
			}
		}
		return total_page;
	}

	@Override
	public ArrayList<String> getCollectionValues(List<List<String>> rawData) {
		ArrayList<String> questData = new ArrayList<String>();
		for (int i = 0; i < rawData.size(); i++) {
			questData.add(rawData.iterator().next().get(i));
		}
		return questData;
	}

	@Override
	public int counting_table(List<Integer> tableOrder) {
		System.out.println("MyLog:" + tableOrder.size());
		int tmp_check = 0;
		for (int i = 1; i < tableOrder.size(); i++) {
			int compare = tableOrder.get(i - 1);
			int compareTo = tableOrder.get(i);

			System.out.println("MyLog1:" + compare + ":" + compareTo);

			if (compare < compareTo) {
				tmp_check = i;
			}
			System.out.println("MyLog2:" + tmp_check);
			System.out.println("MyLogi:" + i);
		}
		return tmp_check;
	}

	private int setCoutingPage_start(int page, int total_page) {
		int adding_value = page;

		if (page < 5) {
			adding_value = 5;
		}
		return adding_value;
	}

	private int setCoutingPage_end(int page, int total_page) {
		int adding_value_end = 0;

		if (page >= 5) {
			if (page - total_page > 0) {
				adding_value_end = -10;
			}
		}
		return adding_value_end;
	}
}