package le.inv.ho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import net.md_5.bungee.api.plugin.Listener;

public class Arabic implements Listener {
	
	public static String changeArabic(String str) {
		String text = str.replace("?", "؟").replace("!", "!").replace("@", "@").replace("#", "#").replace("$", "t").replace("%", "t").replace("^", "^").replace("&", "&")
				.replace("*", "t").replace("(", "t").replace("[", "t").replace("]", "t").replace("(", ";").replace(":", "t").replace(")", "t").replace("_", "_").replace("+", "-").replace("{", "}").replace("}", "{").replace("-", "-")
				.replace("/", "/").replace("<", "<").replace(">", ">").replace(",", "t").replace(";", "t").replace("'", "t").replace("`", "t").replace("~", "~")
				.replace("|", "|").replace("+", "").replace("أ", "ا").replace("إ", "ا").replace("ٌ", "").replace("ً", "").replace("َ", "").replace("ِ", "").replace("ٍ", "")
				.replace("ْ", "").replace("آ", "ا").replace("’", "").replace(",", "").replace("&a", "").replace("&1", "").replace("&2", "").replace("&3", "")
				.replace("&4", "").replace("&5", "").replace("&6", "").replace("&7", "").replace("&8", "").replace("&9", "").replace("&0", "").replace("&b", "")
				.replace("&c", "").replace("&d", "").replace("&e", "").replace("&f", "").replace("&g", "").replace("&h", "").replace("&n", "").replace("&m", "")
				.replace("&u", "").replace("&r", "");

		
		ArrayList<String> array1 = new ArrayList<String>(Arrays.asList(text.split(" ")));
		
		StringBuilder sb = new StringBuilder();
		for (String s : array1) {
		    sb.append(reverseCharts(s));
		    sb.append(" ");
		}
		
		String end = reverseWord(sb.toString().replace("	", " ")).replace("$", "");
		ArrayList<String> arrayend = new ArrayList<String>(Arrays.asList(end.split(" ")));
		
		
		ArrayList<String> last = new ArrayList<String>();
		StringBuilder sb3 = new StringBuilder();

		for (int i = 0; i < arrayend.size(); i++) {
			String part = arrayend.get(i).replace("$", "");
			if (isEnglish(part)) {
				sb3.append(reverseCharts(reverseWord(part)));
				sb3.append(" ");
			} else {
				StringBuilder sb2 = new StringBuilder();
					if (part.length() == 1) {
						String part2 = part.replaceFirst(String.valueOf(part.charAt(0)), charLastIn(part.charAt(0)));
						sb2.append(part2);
					} else {
						if (String.valueOf(part.charAt(1)).equals("ا") || String.valueOf(part.charAt(1)).equals("ء") || String.valueOf(part.charAt(1)).equals("ؤ") || String.valueOf(part.charAt(1)).equals("ر") || String.valueOf(part.charAt(1)).equals("و") || String.valueOf(part.charAt(1)).equals("ز") || String.valueOf(part.charAt(1)).equals("ذ")) {
							String part2 = part.replaceFirst(String.valueOf(part.charAt(0)), charLastOut(part.charAt(0))).replace("$", "");
							sb2.append(part2);
						} else {
							String part2 = part.replaceFirst(String.valueOf(part.charAt(0)), charLastIn(part.charAt(0))).replace("$", "");
							sb2.append(part2);
						}
					}
				sb2.replace((sb2.length() - 1), (sb2.length()), charFirst(sb2.charAt(sb2.length() - 1)));
				last.add(sb2.toString());
				sb3.append(sb2.toString());
				sb3.append(" ");
			}
		}
		String laststr = sb3.toString().replace("	", " ");
		String laststr2 = laststr.replace("ض", "ﻀ").replace("ص", "ﺼ").replace("ث", "ﺜ").replace("ق", "ﻘ").replace("ف", "ﻔ").replace("غ", "ﻐ").replace("ع", "ﻌ").replace("ه", "ﻬ").replace("خ", "ﺨ")
		.replace("ح", "ﺤ").replace("ج", "ﺠ").replace("د", "ﺩ").replace("ش", "ﺸ").replace("س", "ﺴ").replace("ي", "ﻴ").replace("ب", "ﺒ").replace("ل", "ﻟ").replace("ا", "ﺎ")
		.replace("ت", "ﺘ").replace("ن", "ﻨ").replace("م", "ﻤ").replace("ك", "ﻜ").replace("ط", "ﻄ").replace("ئ", "ﺌ").replace("ء", "ﺀ").replace("ؤ", "ﺆ").replace("ر", "ﺮ")
		.replace("ى", "ﻰ").replace("ة", "ﺔ").replace("و", "ﻮ").replace("ز", "ﺰ").replace("ظ", "ﻈ").replace("ذ", "ﺬ").replace("ذ", "ﺬ").replace("أ", "ﺎ").replace("إ", "ﺎ")
		.replace("آ", "ﺎ").replace("َ", "").replace("ً", "").replace("ُ", "").replace("$", "");
		if (containsArabicChars(laststr2)) {
			return laststr2;
		} else {
			return str;
		}
	}
	
	public static boolean containsArabicChars(String msg) {
		if (msg.contains("ﻀ") || msg.contains("ﺼ") || msg.contains("ﺜ") || msg.contains("ﻘ") || msg.contains("ﻔ") || msg.contains("ﻔ") || msg.contains("ﻌ")
				 || msg.contains("ﻬ") || msg.contains("ﺨ") || msg.contains("ﺤ") || msg.contains("ﺠ") || msg.contains("ﺩ") || msg.contains("ﺸ") || msg.contains("ﺴ")
				 || msg.contains("ﻴ") || msg.contains("ﺒ") || msg.contains("ﻟ") || msg.contains("ﺎ") || msg.contains("ﺘ") || msg.contains("ﻨ") || msg.contains("ﻤ")
				 || msg.contains("ﻜ") || msg.contains("ﻄ") || msg.contains("ﺌ") || msg.contains("ﺀ") || msg.contains("ﺆ") || msg.contains("ﺮ") || msg.contains("ﺎ")
				 
				 || msg.contains("ﺿ")|| msg.contains("ﺻ")|| msg.contains("ﺛ")|| msg.contains("ﻗ")|| msg.contains("ﻓ")|| msg.contains("ﻏ")|| msg.contains("ﻋ")
				 || msg.contains("ﻫ")|| msg.contains("ﺧ")|| msg.contains("ﺣ")|| msg.contains("ﺟ")|| msg.contains("ﺩ")|| msg.contains("ﺷ")|| msg.contains("ﺷ")
				 || msg.contains("ﺳ")|| msg.contains("ﻳ")|| msg.contains("ﺑ")|| msg.contains("ﺑ")|| msg.contains("ﻟ")|| msg.contains("ﺍ")|| msg.contains("ﺗ")
				 || msg.contains("ﻧ")|| msg.contains("ﻣ")|| msg.contains("ﻛ")|| msg.contains("ﻃ")|| msg.contains("ﺋ")|| msg.contains("ﺀ")|| msg.contains("ﺅ")
				 || msg.contains("ﺭ")|| msg.contains("ﻯ")|| msg.contains("ﺓ")|| msg.contains("ﻭ")|| msg.contains("ﺯ")|| msg.contains("ﻇ")|| msg.contains("ﺫ")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String charFirst(char oldchar2) {
		String oldchar = String.valueOf(oldchar2);
		if (oldchar == "ض") {
			return "ﺿ";
		} else if (oldchar == "ص") {
			return "ﺻ";
		} else if (oldchar == "ث") {
			return "ﺛ";
		} else if (oldchar == "ق") {
			return "ﻗ";
		} else if (oldchar == "ف") {
			return "ﻓ";
		} else if (oldchar == "غ") {
			return "ﻏ";
		} else if (oldchar == "ع") {
			return "ﻋ";
		} else if (oldchar == "ه") {
			return "ﻫ";
		} else if (oldchar == "خ") {
			return "ﺧ";
		} else if (oldchar == "ح") {
			return "ﺣ";
		} else if (oldchar == "ج") {
			return "ﺟ";
		} else if (oldchar == "د") {
			return "ﺩ";
		} else if (oldchar == "ش") {
			return "ﺷ";
		} else if (oldchar == "س") {
			return "ﺳ";
		} else if (oldchar == "ي") {
			return "ﻳ";
		} else if (oldchar == "ب") {
			return "ﺑ";
		} else if (oldchar == "ل") {
			return "ﻟ";
		} else if (oldchar == "ا") {
			return "ﺍ";
		} else if (oldchar == "ت") {
			return "ﺗ";
		} else if (oldchar == "ن") {
			return "ﻧ";
		} else if (oldchar == "م") {
			return "ﻣ";
		} else if (oldchar == "ك") {
			return "ﻛ";
		} else if (oldchar == "ط") {
			return "ﻃ";
		} else if (oldchar == "ئ") {
			return "ﺋ";
		} else if (oldchar == "ء") {
			return "ﺀ";
		} else if (oldchar == "ؤ") {
			return "ﺅ";
		} else if (oldchar == "ر") {
			return "ﺭ";
		} else if (oldchar == "ى") {
			return "ﻯ";
		} else if (oldchar == "ة") {
			return "ﺓ";
		} else if (oldchar == "و") {
			return "ﻭ";
		} else if (oldchar == "ز") {
			return "ﺯ";
		} else if (oldchar == "ظ") {
			return "ﻇ";
		} else if (oldchar == "ذ") {
			return "ﺫ";
		} else {
			return String.valueOf(oldchar);
		}
	}
	
	public static String charLastOut(char oldchar2) {
		String oldchar = String.valueOf(oldchar2);
		if (oldchar == "ض") {
			return "ﺽ";
		} else if (oldchar == "ص") {
			return "ﺹ";
		} else if (oldchar == "ث") {
			return "ﺙ";
		} else if (oldchar == "ق") {
			return "ﻕ";
		} else if (oldchar == "ف") {
			return "ﻑ";
		} else if (oldchar == "غ") {
			return "ﻍ";
		} else if (oldchar == "ع") {
			return "ﻉ";
		} else if (oldchar == "ه") {
			return "ﻩ";
		} else if (oldchar == "خ") {
			return "ﺥ";
		} else if (oldchar == "ح") {
			return "ﺡ";
		} else if (oldchar == "ج") {
			return "ﺝ";
		} else if (oldchar == "د") {
			return "ﺩ";
		} else if (oldchar == "ش") {
			return "ﺵ";
		} else if (oldchar == "س") {
			return "ﺱ";
		} else if (oldchar == "ي") {
			return "ﻱ";
		} else if (oldchar == "ب") {
			return "ﺏ";
		} else if (oldchar == "ل") {
			return "ﻝ";
		} else if (oldchar == "ا") {
			return "ﺍ";
		} else if (oldchar == "ت") {
			return "ﺕ";
		} else if (oldchar == "ن") {
			return "ﻥ";
		} else if (oldchar == "م") {
			return "ﻡ";
		} else if (oldchar == "ك") {
			return "ﻙ";
		} else if (oldchar == "ط") {
			return "ﻁ";
		} else if (oldchar == "ئ") {
			return "ﺉ";
		} else if (oldchar == "ء") {
			return "ﺀ";
		} else if (oldchar == "ؤ") {
			return "ﺅ";
		} else if (oldchar == "ر") {
			return "ﺭ";
		} else if (oldchar == "ى") {
			return "ﻯ";
		} else if (oldchar == "ة") {
			return "ﺓ";
		} else if (oldchar == "و") {
			return "ﻭ";
		} else if (oldchar == "ز") {
			return "ﺯ";
		} else if (oldchar == "ظ") {
			return "ﻅ";
		} else if (oldchar == "ذ") {
			return "ﺫ";
		} else {
			return String.valueOf(oldchar);
		}
	}
	public static String charLastIn(char oldchar2) {
		String oldchar = String.valueOf(oldchar2);
		if (oldchar == "ض") {
			return "ﺾ";
		} else if (oldchar == "ص") {
			return "ﺺ";
		} else if (oldchar == "ث") {
			return "ﺚ";
		} else if (oldchar == "ق") {
			return "ﻖ";
		} else if (oldchar == "ف") {
			return "ﻒ";
		} else if (oldchar == "غ") {
			return "ﻎ";
		} else if (oldchar == "ع") {
			return "ﻊ";
		} else if (oldchar == "ه") {
			return "ﻪ";
		} else if (oldchar == "خ") {
			return "ﺦ";
		} else if (oldchar == "ح") {
			return "ﺢ";
		} else if (oldchar == "ج") {
			return "ﺞ";
		} else if (oldchar == "د") {
			return "ﺪ";
		} else if (oldchar == "ش") {
			return "ﺶ";
		} else if (oldchar == "س") {
			return "ﺲ";
		} else if (oldchar == "ي") {
			return "ﻲ";
		} else if (oldchar == "ب") {
			return "ﺐ";
		} else if (oldchar == "ل") {
			return "ﻞ";
		} else if (oldchar == "ا") {
			return "ﺎ";
		} else if (oldchar == "ت") {
			return "ﺖ";
		} else if (oldchar == "ن") {
			return "ﻦ";
		} else if (oldchar == "م") {
			return "ﻢ";
		} else if (oldchar == "ك") {
			return "ﻚ";
		} else if (oldchar == "ط") {
			return "ﻂ";
		} else if (oldchar == "ئ") {
			return "ﺊ";
		} else if (oldchar == "ء") {
			return "ﺊ";
		} else if (oldchar == "ؤ") {
			return "ﺅ";
		} else if (oldchar == "ر") {
			return "ﺮ";
		} else if (oldchar == "ى") {
			return "ﻰ";
		} else if (oldchar == "ة") {
			return "ﺔ";
		} else if (oldchar == "و") {
			return "ﻮ";
		} else if (oldchar == "ز") {
			return "ﺰ";
		} else if (oldchar == "ظ") {
			return "ﻆ";
		} else if (oldchar == "ذ") {
			return "ﺬ";
		} else if (oldchar == "$") {
			return "$";
		} else if (oldchar == "%") {
			return "%";
		} else {
			return String.valueOf(oldchar);
		}
	}
	
	public static String reverseCharts(String str){  
	    String words[]=str.split("\\s");  
	    String reverseWord="";  
	    for(String w:words){
	        StringBuilder sb=new StringBuilder(w);  
	        sb.reverse();  
	        reverseWord+=sb.toString()+" ";  
	    }  
	    return reverseWord.trim();  
	}
	
    static String reverseWord(String str)  {
    	  
        // Specifying the pattern to be searched 
        Pattern pattern = Pattern.compile("\\s"); 
  
        // splitting String str with a pattern 
        // (i.e )splitting the string whenever their 
        //  is whitespace and store in temp array. 
        String[] temp = pattern.split(str); 
        String result = ""; 
  
        // Iterate over the temp array and store 
        // the string in reverse order. 
        for (int i = 0; i < temp.length; i++) { 
            if (i == temp.length - 1) 
                result = temp[i] + result; 
            else
                result = " " + temp[i] + result; 
        } 
        return result; 
    } 
	
    public static boolean isEnglish(String msg) {
    	if (msg.contains("q") || msg.contains("w") || msg.contains("e") || msg.contains("r") || msg.contains("t") || msg.contains("y") || msg.contains("u")
    			 || msg.contains("i") || msg.contains("o") || msg.contains("p") || msg.contains("a") || msg.contains("s") || msg.contains("d") || msg.contains("f")
    			 || msg.contains("g") || msg.contains("h") || msg.contains("j") || msg.contains("k") || msg.contains("l") || msg.contains("z") || msg.contains("x")
    			 || msg.contains("c") || msg.contains("v") || msg.contains("b") || msg.contains("n") || msg.contains("m") || msg.contains("1") || msg.contains("2")
    			 || msg.contains("3") || msg.contains("4") || msg.contains("5") || msg.contains("6") || msg.contains("7") || msg.contains("8") || msg.contains("9")
    			 || msg.contains("0")) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
