import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Character Based Features for MAPonSMtext.
 *
 * @author Osama Akhter
 */

public class CharacterFeatures {

    /**
     * Returns the percentage of semicolons to the total number of characters in
     * the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of whitespace in the sample.
     */
    public static double percentSemicolon(String text) {
        return Double.parseDouble(String.format("%.2f", 100 * (double) countSemicolon(text) / countChar(text)));
    }

    /**
     * Returns the percentage of punctuation to the total number of characters
     * in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of punctuation characters in the sample.
     */
    public static double percentPunctuation(String text) {
        return 100 * (double) countPunctuation(text) / countChar(text);
    }

    /**
     * Returns the percentage of commas to the total number of characters in the
     * text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of commas in the sample.
     */
    public static double percentComma(String text) {
        return 100 * (double) countComma(text) / countChar(text);
    }

    /**
     * Returns the percentage of upper-case characters to the total number of
     * characters in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of upper-case characters in the sample.
     */
    public static double percentUpper(String text) {
        return 100 * (double) countUpper(text) / countChar(text);
    }

    /**
     * Returns the percentage of digit characters to the total number of
     * characters in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of digits in the sample.
     */
    public static double percentDigit(String text) {
        return 100 * (double) countDigit(text) / countChar(text);
    }

    /**
     * Returns the percentage of tab characters to the total number of
     * characters in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of tabs in the sample.
     */
    public static double percentTab(String text) {
        return 100 * (double) countTab(text) / countChar(text);
    }

    /**
     * Returns the percentage of special characters to the total number of
     * characters in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of special characters in the sample.
     */
    public static double percentSpecialChar(String text) {
        return 100 * (double) countSpecialChar(text) / countChar(text);
    }

    /**
     * Returns the percentage of alphabetic characters to the total number of
     * characters in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of alphabetic characters in the sample.
     */
    public static double percentAlphabet(String text) {
        return 100 * (double) countAlphabet(text) / countChar(text);
    }

    /**
     * Returns the percentage of whitespace characters to the total number of
     * characters in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The percentage of whitespace in the sample.
     */
    public static double percentWhitespace(String text) {
        return 100 * (double) countWhitespace(text) / countChar(text);
    }

    /**
     * Returns the count of whitespace characters found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of whitespace in the sample.
     */
    public static long countWhitespace(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of upper-case English alphabets<code>(A-Z)</code> found
     * in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of upper-case alphabets in the sample.
     */
    public static long countUpper(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of alphabets<code>(A-Z, a-z)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of alphabets in the sample.
     */
    public static long countAlphabet(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (Character.isAlphabetic(text.charAt(i))) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of digits<code>(0-9)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of digits in the sample.
     */
    public static long countDigit(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (Character.isDigit(text.charAt(i))) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of tab characters<code>(\t)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of tabs in the sample.
     */
    public static long countTab(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (text.charAt(i) == '\t') {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of braces(Parentheses<code>()</code>,
     * curlies<code>{}</code> and square braces<code>[]</code>) found in the
     * text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of braces in the sample.
     */
    public static long countBrace(String text) {
        return countLeftParenthesis(text) + countRightParenthesis(text) + countLeftCurlyBrace(text)
                + countRightCurlyBrace(text) + countLeftSquareBrace(text) + countRightSquareBrace(text);
    }

    /**
     * Returns the count of characters that are not whitespace in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of non-whitespace characters in the sample.
     */
    public static long countNonWhitespace(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (!Character.isWhitespace(text.charAt(i))) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of punctuation characters found in the text sample.
     * <p>
     * This method matches each character with the regular expression
     * \p{IsPunctuation} and counts them.
     *
     * @param	text	The input text sample.
     * @return	The count of punctuations in the sample.
     */
    public static long countPunctuation(String text) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (text.substring(i, i + 1).matches("\\p{IsPunctuation}")) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of total characters found in the text sample which is
     * equal to the length of the sample.
     *
     * @param	text	The input text sample.
     * @return	The length of the sample.
     */
    public static long countChar(String text) {
        return text.length();
    }

    /**
     * Returns the count of special characters found in the text sample.
     * <p>
     * Special characters are any characters except alphabets, numbers and
     * whitespace characters.
     *
     * @param	text	The input text sample.
     * @return	The count of special characters in the sample.
     */
    public static long countSpecialChar(String text) {
        int num = 0;
        for (int i = 0, l = text.length(); i < l; i++) {
            if (text.substring(i, i + 1).matches("[^A-Za-z0-9\\s]")) {
                num++;
            }
        }
        return num;
    }

    /**
     * Returns the count of pipe characters or vertical bar<code>(|)</code>
     * found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of pipes in the sample.
     */
    public static long countPipe(String text) {
        return numChars(text, '|');
    }

    /**
     * Returns the count of underscores<code>(_)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of underscores in the sample.
     */
    public static long countUnderscore(String text) {
        return numChars(text, '_');
    }

    /**
     * Returns the count of tildes<code>(~)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of tildes in the sample.
     */
    public static long countTildes(String text) {
        return numChars(text, '~');
    }

    public static long countAtSign(String text) {
        return numChars(text, '@');
    }

    /**
     * Returns the count of semicolons<code>(;)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of semicolons in the sample.
     */
    public static long countSemicolon(String text) {
        return numChars(text, ';');
    }

    /**
     * Returns the count of less than signs<code>(<)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of less than signs in the sample.
     */
    public static long countLessThan(String text) {
        return numChars(text, '<');
    }

    /**
     * Returns the count of greater than signs<code>(>)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of greater than signs in the sample.
     */
    public static long countGreaterThan(String text) {
        return numChars(text, '>');
    }

    /**
     * Returns the count of ampersands<code>(&)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of ampersands in the sample.
     */
    public static long countAmpersand(String text) {
        return numChars(text, '&');
    }

    /**
     * Returns the count of asterisks<code>(*)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of asterisks in the sample.
     */
    public static long countAsterisk(String text) {
        return numChars(text, '*');
    }

    /**
     * Returns the count of question marks<code>(?)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of question marks in the sample.
     */
    public static long countQuestion(String text) {
        return numChars(text, '?');
    }

    /**
     * Returns the count of dollar signs<code>($)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of in dollar signs the sample.
     */
    public static long countDollar(String text) {
        return numChars(text, '$');
    }

    /**
     * Returns the count of equal signs<code>(=)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of equal signs in the sample.
     */
    public static long countEqual(String text) {
        return numChars(text, '=');
    }

    /**
     * Returns the count of slashes<code>(\ or /)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of slashes in the sample.
     */
    public static long countSlash(String text) {
        return numChars(text, '/') + numChars(text, '\\');
    }

    /**
     * Returns the count of Left Parentheses<code>'('</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of left parentheses in the sample.
     */
    public static long countLeftParenthesis(String text) {
        return numChars(text, '(');
    }

    /**
     * Returns the count of Right Parentheses<code>')'</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of right parentheses in the sample.
     */
    public static long countRightParenthesis(String text) {
        return numChars(text, ')');
    }

    /**
     * Returns the count of left curly braces<code>({)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of left curlies in the sample.
     */
    public static long countLeftCurlyBrace(String text) {
        return numChars(text, '{');
    }

    /**
     * Returns the count of right curly braces<code>(})</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of right curlies in the sample.
     */
    public static long countRightCurlyBrace(String text) {
        return numChars(text, '}');
    }

    /**
     * Returns the count of left square braces<code>([)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of left square braces in the sample.
     */
    public static long countLeftSquareBrace(String text) {
        return numChars(text, '[');
    }

    /**
     * Returns the count of right square braces<code>(])</code> found in the
     * text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of right square braces in the sample.
     */
    public static long countRightSquareBrace(String text) {
        return numChars(text, ']');
    }

    /**
     * Returns the count of percentage signs<code>(%)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of percent signs in the sample.
     */
    public static long countPercent(String text) {
        return numChars(text, '%');
    }

    /**
     * Returns the count of plus signs<code>(+)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of plus signs in the sample.
     */
    public static long countPlus(String text) {
        return numChars(text, '+');
    }

    /**
     * Returns the count of single quotes or apostrophes<code>(')</code> found
     * in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of single quotes in the sample.
     */
    public static long countSingleQuote(String text) {
        return numChars(text, '\'');
    }

    /**
     * Returns the count of periods or full stops<code>(.)</code> found in the
     * text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of periods in the sample.
     */
    public static long countPeriod(String text) {
        return numChars(text, '.');
    }

    /**
     * Returns the count of exclamations<code>(!)</code> found in the text
     * sample.
     *
     * @param	text	The input text sample.
     * @return	The count of exclamation characters in the sample.
     */
    public static long countExclamation(String text) {
        return numChars(text, '!');
    }

    /**
     * Returns the count of hyphens<code>(-)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of hyphens in the sample.
     */
    public static long countHyphen(String text) {
        return numChars(text, '-');
    }

    /**
     * Returns the count of commas<code>(,)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of commas in the sample.
     */
    public static long countComma(String text) {
        return numChars(text, ',');
    }

    /**
     * Returns the count of colons<code>(:)</code> found in the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of colon in the sample.
     */
    public static long countColon(String text) {
        return numChars(text, ':');
    }

    /**
     * Returns the count of multiple question marks<code>(??...)</code> found in
     * the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of multiple question marks in the sample.
     */
    public static long countMultiQuestion(String text) {
        return countRegex(text, "\\?{2,}");
    }

    /**
     * Returns the count of multiple exclamations<code>(!!...)</code> found in
     * the text sample.
     *
     * @param	text	The input text sample.
     * @return	The count of multiple consecutive exclamation marks in the
     * sample.
     */
    public static long countMultiExclamation(String text) {
        return countRegex(text, "!{2,}");
    }

    /**
     * Returns the count of ellipsis<code>(...)</code> found in the text sample.
     * <p>
     * Ellipsis is a sequence of 2 or more continuous periods. The number of
     * periods do not matter.
     *
     * @param	text	The input text sample.
     * @return	The count of ellipsis in the sample.
     */
    public static long countEllipsis(String text) {
        return countRegex(text, "\\.{2,}");
    }

    private static int numChars(String text, char c) {
        int num = 0;

        for (int i = 0, l = text.length(); i < l; i++) {
            if (text.charAt(i) == c) {
                num++;
            }
        }
        return num;
    }

    private static long countRegex(String text, String regex) {
        int count = 0;
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            count++;
        }
        return count;
    }

    ///Osama INayat Methods Start From Here
    public static double simpsonsCalculations(String file, String fileName) {
//            modifiedStringWithFeatures = null;
        Map<String, Integer> myWordsFrequency = gettingWordCounts(file, fileName);
        double N = 0;//N to count the total number of species/words/letters present in the sample
        double summation_n = 0;// the total number of organisms of a particular species 
        //Snake way of variable writing is used for specific particular mention of n according to simpsons Formula                               
        for (String myKeys : myWordsFrequency.keySet()) {
//                if(myKeys.equals(" "))
//                    continue;
            N += myWordsFrequency.get(myKeys);
//                System.out.println(myKeys+" "+myWordsFrequency.get(myKeys)+" N value"+N);
            summation_n += myWordsFrequency.get(myKeys) * (myWordsFrequency.get(myKeys) - 1);
        }
        double result = 1 - (summation_n / (N * (N - 1)));
        result = Double.parseDouble(String.format("%.2f", result));
        return result;
    }

    //Helper Method
    public static Map<String, Integer> gettingWordCounts(String file, String fileName) {
//            modifiedStringWithFeatures = new StringBuffer("<"+fileName+">");
//            modifiedStringWithFeatures.append(file);
        file = file.toLowerCase();
        Map<String, Integer> myWordsFrequency = new HashMap<>();
        String[] splited = tokenizeWords(file);
//            String[] splited = file.split(" ");
        for (String word : splited) {
            Integer frequency = myWordsFrequency.get(word);
            if (frequency == null) {
                frequency = 1;
            } else {
                frequency++;
            }
            myWordsFrequency.put(word, frequency);
        }
        return myWordsFrequency;
    }

    public static double sichelS(String file, String fileName) {
//            modifiedStringWithFeatures = null;
        float V2 = 0;//number Of Words Occuring Twice
        float V = 0;//number of different words
        Map<String, Integer> myWordsFrequency = gettingWordCounts(file, fileName);
//            System.out.println(modifiedStringWithFeatures);
        for (String myKeys : myWordsFrequency.keySet()) {
            if (myWordsFrequency.get(myKeys) == 2) {
                V2++;
            }
            V++;
        }
        double result = V2 / V;
        result = Double.parseDouble(String.format("%.2f", result));
//            modifiedStringWithFeatures.append("</").append(fileName).append("> ").append(result).append("\n"); 
//            System.out.println(modifiedStringWithFeatures);
        return result;
    }

    public static double UpperCaseWordPercentage(String upperCaseWordCounter) {
        float numberOfCapitalWords = 0;
        String[] temp = upperCaseWordCounter.split(" ");
        for (String word : temp) {
            float capital = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    capital++;
                }
            }
            if (((capital) / word.length()) * 100 == 100) {
                numberOfCapitalWords++;
            }
        }
        double result = (numberOfCapitalWords / (temp.length)) * 100;
        result = Double.parseDouble(String.format("%.2f", result));
        return result;
    }

    public static int continuseMultipleQuestionMarks(String havingQuestionMarksOrExclamatory, char myCharacter) {
        int realCounter = 0;
        String[] myResult = tokenizeWords(havingQuestionMarksOrExclamatory);
//            String[] myResult = havingQuestionMarksOrExclamatory.split(" ");
        for (String word : myResult) {
            for (int i = 0; i < word.length(); i++) {
                int multipleCounter = 0;
                int j = i;
                while (j < word.length() && word.charAt(j) == myCharacter) {
                    multipleCounter++;
                    if (multipleCounter == 2) {
                        realCounter++;
                    }
                    i = j;
                    j++;
                }
            }
        }
//            System.out.println(realCounter);
        return realCounter;
    }

    ////////////////////////NAEEM 'S IMPLEMENTATION//////////////////
    public static double countPercOfCertainty(String document) {
//        String s[] = document.split("\\r?\\n");
//        ArrayList<String> list = new ArrayList<>();
//        for (String item : s) {
//            list.addAll(Arrays.asList(item.split(" ")));
//        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
		
        int certainty = 0;
        Set<String> negs = new HashSet<>(Arrays.asList(new String[]
            {"always", "hamesha", "hmesha", "never", "ever", "kabi", "kabhi", "kbhi", "kbi", "forever"}));
        for (int i = 0; i < list.size(); i++) {
//            if (negs.contains(list.get(i).toLowerCase())) {
            if (negs.contains(list.get(i))) {
                certainty++;
            }
        }
        return ((double) certainty / (double) list.size()) * 100.0;
    }

    public static double countPercOfNegations(String document) {
//        String s[] = document.split("\\r?\\n");
//        ArrayList<String> list = new ArrayList<>();
//        for (String item : s) {
//            list.addAll(Arrays.asList(item.split(" ")));
//        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
 
        int numberOfNegations = 0;
        Set<String> negs = new HashSet<>(Arrays.asList(new String[]
            {"no", "na", "not", "never", "ni", "nahi", "nah", "nae", "niii"}));
        for (int i = 0; i < list.size(); i++) {
//            if (negs.contains(list.get(i).toLowerCase())) {
            if (negs.contains(list.get(i))) {
                numberOfNegations++;
            }
        }
        return ((double) numberOfNegations / (double) list.size()) * 100.0;
    }

    public static double countPercOfAssents(String document) {
//        String s[] = document.split("\\r?\\n");
//        ArrayList<String> list = new ArrayList<>();
//        for (String item : s) {
//            list.addAll(Arrays.asList(item.split(" ")));
//        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
 
        int assents = 0;
        Set<String> negs = new HashSet<>(Arrays.asList(new String[]
            {"ok", "agree", "alright", "right", "sai", "thek", "k", "okkk", "yes", "haan", "han", "sae", "yup", "yeah", "h"}));
        for (int i = 0; i < list.size(); i++) {
//            if (negs.contains(list.get(i).toLowerCase())) {
            if (negs.contains(list.get(i))) {
                assents++;
            }
        }
        return ((double) assents / (double) list.size()) * 100.0;
    }

    public static double countAvgWordLength(String document) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        
        double totalWords = list.size();
        double totalChars = (double) countChar(document);
        
        return (totalWords / totalChars) * 100;
    }

    //4 number of sentences in a file 
    public static int totalSentences(String document) {
        return document.split("\\r?\\n").length;
    }
    //(7) percentage of question sentences

    public static double percOfQuestionedSentences(String document) {
        return countRegex(document, "\\?+");
    }

    // (8) percentage of words with length 3
    public static double percOfWordsWithLength3(String document) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        double count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 3) {
                count++;
            }
        }
 
        return (count / (double) list.size()) * 100;
    }

    //9) percentage of words with length 4
    public static double percOfWordsWithLength4(String document) {
//        String s[] = document.split("\\r?\\n");
//        ArrayList<String> list = new ArrayList<>();
//        for (String item : s) {
//            list.addAll(Arrays.asList(item.split(" ")));
//        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        double count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                count++;
            }
        }
        
        return (count / (double) list.size()) * 100;
    }

    public static double avgSenetenceLength(String document) {
        String s[] = document.split("\\r?\\n");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        
        double totalSentences = Double.parseDouble(Integer.toString(s.length));
        double totalWords = Double.parseDouble(Integer.toString(list.size()));
        
        return (totalSentences / totalWords) * 100;
    }

    //count of brackets 
    public static int countBrackets(String document) {
        int count = 0;
        for(int i = 0; i < document.length(); i++)
            switch (document.charAt(i)){
                case '{':
                case '}':
                case '(':
                case ')':
                case '[':
                case ']':
                    count++;
            }
        return count;
    }

    public static double countWords(String document) {
        return tokenizeWords(document).length;
    }

    private static double findNumOfDiffWords(String document) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        
        Set<String> diffWords = new HashSet<>(list);
        return diffWords.size();
    }

    public static double honoreRMeasure(String document) {

        double N = countWords(document);
        double hapexLegomena = hapaxLegomena(document);
        double V = findNumOfDiffWords(document);

        double i = 100 * Math.log10(N);
        double d = 1 - (hapexLegomena / V);

        return i / d;
    }

    public static double brunetWMeasure(String text) {

        // tokenize string and generate frequency map
        Stream<String> tokens = Stream.of(tokenizeWords(text)).parallel();
        Map<String, Long> frequencyMap
                = tokens.collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        // N = sum of frequencies; V = number of entries in map
        long N = frequencyMap.values().stream().mapToLong(l -> l).sum();
        long V = frequencyMap.size();

        // scaling constant
        double a = 0.172d;

        double W = (V - a) / Math.log(N);

        return W;
    }

    public static double yuleK(String text) {
        // tokenize string and generate frequency map
        Stream<String> tokens = Stream.of(tokenizeWords(text)).parallel();
        Map<String, Long> frequencyMap = tokens.collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        // s1 = N = sum of frequencies; s2 = sum of squares of frequencies
        long s1 = frequencyMap.values().stream().mapToLong(l -> l).sum();
        long s2 = frequencyMap.values().stream().mapToLong(l -> l * l).sum();

        double K = 10000 * (double) (s2 - s1) / (s1 * s1);

        return K;
    }

    public static long hapaxLegomena(String text) {
        Stream<String> stream = Stream.of(tokenizeWords(text)).parallel();
        Map<String, Long> frequencyMap = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        return Collections.frequency(frequencyMap.values(), 1l);
    }

    /////Unimplemented Features By Osama Akhtar
    /**
     * Finds the count of emoji in a given text sample. <br />
     * This method uses an emoji dictionary contained in file
     * <code>emoji.txt</code> in the root of the project. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains emoji with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Count of emoji in the sample.
     */
    public static long countEmoji(String text) {
        // emoji list
        List<String> list = new ArrayList<>();

        // load from file
        try (Scanner sc = new Scanner(new File("emoji.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.isEmpty()) {
                    list.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // load dictionary into HashSet
        Set<String> dictionary = new HashSet<>(list);

        // count emoji
        long num = 0;

        // count emojis in char 2-5-grams
        for (int i = 2; i <= 5; i++) {
            for (String word : charNGramsFromString(text, i)) {
                num += (dictionary.contains(word)) ? 1 : 0;
            }
        }

        return num;
    }

    /**
     * Finds the average count of emoji per message in a text sample. <br />
     * This method uses an emoji dictionary contained in file
     * <code>emoji.txt</code> in the root of the project and treats each line of
     * the input sample as a message. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains emoji with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Average count of emoji per message in the sample.
     */
    public static double averageEmojiPerMessage(String text) {
        return (double) countEmoji(text) / numMessages(text);
    }

    /**
     * Finds the count of English words in a text sample. <br />
     * This method uses an English dictionary contained in file
     * <code>english.txt</code> in the root of the project. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Count of English words in the sample.
     */
    public static long countEnglish(String text) {
        return countDictionary(text, "english.txt");
    }

    /**
     * Finds the count of Roman Urdu words in a text sample. <br />
     * This method treats all words that are not English words or emoji as Roman
     * Urdu words. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Count of Roman Urdu words in the sample.
     */
    public static long countRoman(String text) {
        return text.split(" ").length - countEnglish(text) - countEmoji(text);
    }

    /**
     * Finds the percent of English words in a text sample. <br />
     * This method uses an English dictionary contained in file
     * <code>english.txt</code> in the root of the project. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Percentage of English words in the sample.
     */
    public static double percentEngish(String text) {
        return (double) countEnglish(text) / text.split(" ").length * 100;
    }

    /**
     * Finds the percent of Roman Urdu words in a text sample. <br />
     * This method treats all words that are not English words or emoji as Roman
     * Urdu words. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Percentage of Roman Urdu words in the sample.
     */
    public static double percentRoman(String text) {
        return (double) countRoman(text) / text.split(" ").length * 100;
    }

    /**
     * Finds the ratio of English to Roman Urdu words in a text sample. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Ratio of English words to Roman Urdu words in the sample.
     */
    public static double ratioEnglishToRoman(String text) {
        return (double) countEnglish(text) / countRoman(text);
    }

    /**
     * Finds the count of trendy Slang words in a text sample. <br />
     * This method uses an English dictionary contained in file
     * <code>slang.txt</code> in the root of the project. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Count of Slang words in the sample.
     */
    public static long countSlang(String text) {
        return countDictionary(text, "slang.txt");
    }

    /**
     * Finds the percent of trendy Slang words in a text sample. <br />
     * This method uses an English dictionary contained in file
     * <code>slang.txt</code> in the root of the project. <br />
     * <b>Known Issues:</b><br />
     * This file splits the input sample by space character. If the input text
     * contains words with improper spacing, the method may not be able to count
     * them.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Percentage of Slang words in the sample.
     */
    public static double percentSlang(String text) {
        return (double) countSlang(text) / text.split(" ").length * 100;
    }

    /**
     * Finds the count of words ending with the <code>a</code> character in a
     * text sample. <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Count of words ending with <code>a</code> in the sample.
     */
    public static long countAEnding(String text) {
        return countWordsWithEnding(text, 'a');
    }

    /**
     * Finds the count of words ending with the <code>i</code> character in a
     * text sample. <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Count of words ending with <code>i</code> in the sample.
     */
    public static long countIEnding(String text) {
        return countWordsWithEnding(text, 'i');
    }

    /**
     * Finds the ratio of words ending with the <code>a</code> character to
     * those ending with <code>i</code> character in a text sample. <br />
     *
     * @param	text	The input text sample.
     *
     * @return	Ratio of words ending with <code>a</code> to words ending with
     * <code>i</code> in the sample.
     */
    public static double ratioAEndingsToIEndings(String text) {
        return (double) countAEnding(text) / countIEnding(text);
    }

    /**
     * Finds the <code>size</code> most common consonants in a text sample.
     * <br />
     *
     * @param	text	The input text sample.
     *
     * @return	An array of <code>size</code> most common consonants in the
     * sample.
     */
    public static char[] mostCommonConsonants(String text, int size) {
        if (size <= 0) {
            return null;
        }
//    	IntStream stream = text.chars().parallel();
//    	Map<Character, Long> frequencyMap = 
//				stream.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        char[] characters = text.toLowerCase().toCharArray();
        Map<Character, Long> letters = new HashMap<>();

        for (char c : characters) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || !(c >= 'a' && c <= 'z')) {
                continue;
            }
            if (letters.containsKey(c)) {
                letters.replace(c, letters.get(c) + 1);
            } else {
                letters.put(c, 1l);
            }
        }

        // Sort the map
        List<Entry<Character, Long>> list = new ArrayList<>(letters.entrySet());
        list.sort(Entry.comparingByValue());

        // return array of 'size' top most elements
        char[] result = new char[(size <= 20) ? size : 20];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    //helper
    private static long countDictionary(String text, String dictionaryPath) {
        long num = 0;
        // load dictionary
        Set<String> dictionary = new HashSet<>(getLinesfromFile(dictionaryPath));

        // count number of dictionary words
        for (String word : tokenizeWords(text)) {
            num += (dictionary.contains(word)) ? 1 : 0;
        }
        return num;
    }

    // helper
    private static String[] tokenizeWords(String text) {
        List<String> matches = new ArrayList<>();
        Matcher m = Pattern.compile("((\\b[^\\s]+\\b)((?<=\\.\\w).)?)")
                .matcher(text.toLowerCase());
        while (m.find()) {
            matches.add(m.group(0));
        }

        return matches.toArray(new String[matches.size()]);
    }

    //helper
    private static List<String> getLinesfromFile(String filename) {
        List<String> list = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.isEmpty()) {
                    list.add(line.toLowerCase());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    //helper
    private static long countWordsWithEnding(String text, char c) {
        long num = 0;
        c = (char) ((c >= 'A' && c <= 'Z') ? c + 32 : c);
        for (String word : text.toLowerCase().split("\\W+")) {
            if (!word.isEmpty()) {
                num = (word.charAt(word.length() - 1) == c) ? num + 1 : num;
            }
        }
        return num;
    }

    // helper
    private static long numMessages(String text) {
        int count = 0;
        for (String t : text.split("\\r?\\n")) {
            if (t.isEmpty()) {
                count++;
            }
        }

        return count;
    }

    //Update By Mam Asmara
    public static double countPercOfPersonnelPronoun(String document) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        
        int pronouns = 0;
        Set<String> worsList = new HashSet<>(Arrays.asList(new String[]{"me","i", "ma","mai","main","mein"}));
        for (int i = 0; i < list.size(); i++) {
            if (worsList.contains(list.get(i).toLowerCase())) {
                pronouns++;
            }
        }

        return (double) pronouns / list.size() * 100;
    }

////method to calculate the percentage of personnel pronoun you in english and roman meaning
    public static double countPercOfPersonnelPronounYou(String document) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tokenizeWords(document)));
        int pronouns = 0;
        Set<String> worsList = new HashSet<>(Arrays.asList(new String[]{"you","tum", "tm","tu","ap","aap","u"}));
        for (int i = 0; i < list.size(); i++) {
            if (worsList.contains(list.get(i).toLowerCase())) {
                pronouns++;
            }
        }

        return ((double) pronouns / (double) list.size()) * 100.0;
    }

    public static long countNGramsFromString(String sentence, int noOfGrams) {
        //Tokenize Given String
        List<String> text = Arrays.asList(tokenizeWords(sentence));
        
        //Calculate NGrams
        String[] nGrams = getNGramsFromList(text, noOfGrams);

//        //Print NGrams
//        for (int i = 0; i < nGrams.length; i++) 
//            System.out.println(nGrams[i]);
        
        // Retrurn count of NGrams
        return nGrams.length;
    }

    public static long countCharNGramsFromString(String sentence, int noOfGrams) {
        List<String> text = new ArrayList<>();

        //Tokenize Given String
        for (int i = 0; i < sentence.length(); i++) {
            if (!(Character.isWhitespace(sentence.charAt(i)))) {
                text.add("" + sentence.charAt(i));
            }
        }
        //Calculate NGrams
        String[] nGrams = getNGramsFromList(text, noOfGrams);
//        //Print NGrams
//        for (int i = 0; i < nGrams.length; i++) 
//            System.out.println(nGrams[i]);

        // Retrurn count of NGrams
        return nGrams.length;
    }

    // helper
    private static String[] charNGramsFromString(String sentence, int noOfGrams) {
        List<String> text = new ArrayList<>();

        //Tokenize Given String
        for (int i = 0; i < sentence.length(); i++) {
            if (!(Character.isWhitespace(sentence.charAt(i)))) {
                text.add("" + sentence.charAt(i));
            }
        }
        //Calculate NGrams
        String[] nGrams = getNGramsFromList(text, noOfGrams);

        // Return NGrams
        return nGrams;
    }

    //helper method
    public static String[] getNGramsFromList(List<String> text, int noOfNGrams) {

        if (noOfNGrams < 1 || text == null || text.isEmpty()) {
            throw new IllegalArgumentException(
                    "Check the input Parameters : String Should not be null or empty and Ngram value should be > 1");
        }

        String[] parts = text.toArray(new String[text.size()]);
        String[] nGrams = new String[parts.length - noOfNGrams + 1];

        for (int i = 0; i < parts.length - noOfNGrams + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < noOfNGrams; k++) {
                if (k > 0 && parts[i + k].length() != 1) {
                    sb.append(' ');
                }
                sb.append(parts[i + k]);
            }
            nGrams[i] = sb.toString();
        }

        return nGrams;
    }
    
    public static long countUniqueCharNGramsFromString(String sentence, int noOfGrams){
        List<String> text = new ArrayList<String>();
        
        //Tokenize Given String
        for(int i = 0; i < sentence.length(); i++)
            if( ! Character.isWhitespace(sentence.charAt(i)) )
                text.add("" + sentence.charAt(i));
        //Calculate NGrams
        String[] nGrams = getNGramsFromList(text, noOfGrams);
        
        //Extracting Unique Ngrams
        Set<String> uniqueNGramSet = new HashSet<String>(Arrays.asList(nGrams));
        
        // Retrurn count of NGrams
        return uniqueNGramSet.size();
    }
    
    public static long countUniqueWordNGramsFromString(String sentence, int noOfGrams){
        List<String> text = new ArrayList<String>();
        
        //Tokenize Given String
        String[] tokens = sentence.split(" ");
        for(int i = 0; i < tokens.length; i++)
            text.add(tokens[i]);
        
        //Calculate Ngrams
        String[] nGrams = getNGramsFromList(text, noOfGrams);
        
        //Extracting Unique Ngrams
        Set<String> uniqueNGramSet = new HashSet<String>(Arrays.asList(nGrams));
        // Retrurn count of Unique NGrams
        return uniqueNGramSet.size();
    }

}
