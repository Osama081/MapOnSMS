
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.evaluation.Prediction;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffLoader.ArffReader;

/**
 *
 * @author hewlet packard
 */
public class Test {

    public static void main(String[] args){
try{   
		System.out.println("\t\t\t\t\t\t****************TEAM*********************");
		System.out.println("\t\t\t\t\t\t*\tAsmara safdar\t\t\t*");
		System.out.println("\t\t\t\t\t\t*\tOsama Inayat\t\t\t*");
		System.out.println("\t\t\t\t\t\t*\tOsama Akhtar\t\t\t*");
		System.out.println("\t\t\t\t\t\t*\tAbdullah Khalid\t\t\t*");
		System.out.println("\t\t\t\t\t\t*****************************************");

    
	   System.out.print("Enter The Path:"); 
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.print("Enter The Path Where to save CSV:");
        String cs =  scanner.nextLine();
       

		
		//This will create A file full of features
		fetchingFeatures(path);
		
		//This can be Gender and Age only 
       
		
        String genderArff = creatingArff("Gender.txt");
        String ageArff 	= creatingArff("age.txt");
    
//        String genderArff = "Gender.arff";
//        String ageArff = "age.arff";


        String genderModel = "Gender.model";
        String ageModel = "Age.model";
        
        ARFFtoCSV(genderModel, genderArff, cs+"\\gender.csv", 1);
        ARFFtoCSV(ageModel, ageArff, cs+"\\age.csv", 2);
       


		new File("File.txt").delete();
        new File("File2.txt").delete();
       PrintWriter pw = new PrintWriter("age.arff");
       PrintWriter pw1 = new PrintWriter("Gender.arff");
       pw.print("Nothing Here");
       pw1.println("Here too nothing");
       pw.close();
       pw1.close();
}
 
		catch(Exception e){
                    
		}    
    }

    public static void fetchingFeatures(String path) {
        PrintWriter pw = null,pw1 = null;
        File f = null;
        
        
        
        
        try {
            
            
            
             f = new File(path);
            pw = new PrintWriter("File.txt");
            pw1 = new PrintWriter("File2.txt");
            Scanner sc = null;
			//Commented as we dont need this for the testing files 
           // Scanner gender = new Scanner(new File(data));

            for (File file : f.listFiles()) {
                String fileData = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
                System.out.println("Loading :"+file.getName());
		
               //one will be for age and one will be for the gender 
               //pw is for the Gender features file
               //pw1 is for th              

               
//               simpsonsCalculations
//               Disabled For Gender
//                  pw.print(CharacterFeatures.simpsonsCalculations(fileData, ""));
//                pw.print(",");
                double input = CharacterFeatures.simpsonsCalculations(fileData, "");
//                pw1.print(input);
//                pw1.print(",");
                
                
//                sichelS
                input =CharacterFeatures.sichelS(fileData, "");
                pw.print(input);
                pw.print(",");
//                pw1.print(input);
//                pw1.print(",");
                
                
//            percentSemicolon    
                input = CharacterFeatures.percentSemicolon(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//              percentPuncuation
                input = CharacterFeatures.percentPunctuation(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//              percentComma  
                input = CharacterFeatures.percentComma(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countWhitespaces
                input = CharacterFeatures.countWhitespace(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");

                
//                countUpper
                input = CharacterFeatures.countUpper(fileData);
                pw.print(input);
                pw.print(",");
               
                pw1.print(input);
                pw1.print(",");
                
                
//                countMultiQuestion
                input = CharacterFeatures.countMultiQuestion(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//                countMultiExclamation
                input = CharacterFeatures.countMultiExclamation(fileData);
                pw.print(input);
                pw.print(",");
      
                pw1.print(input);
                pw1.print(",");
                
//                countUnderscore
                pw.print(CharacterFeatures.countUnderscore(fileData));
                pw.print(",");
                pw1.print(CharacterFeatures.countUnderscore(fileData));
                pw1.print(",");
                
//                countTildes
//                disabled for gender
//                pw.print(CharacterFeatures.countTildes(fileData));
//                pw.print(",");
                input = CharacterFeatures.countTildes(fileData);
                pw1.print(input);
                pw1.print(",");
                
//                countAtSign
                input = CharacterFeatures.countAtSign(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");

                
                
                
//                countSemicolons
                input = CharacterFeatures.countSemicolon(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
               
//               countLessThan
                input = CharacterFeatures.countLessThan(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
//                countGreaterThan
                input = CharacterFeatures.countGreaterThan(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countAmpersand
                input = CharacterFeatures.countAmpersand(fileData);
                pw.print(input);
                pw.print(",");
               
                pw1.print(input);
                pw1.print(",");


//                countAsterick
                input = CharacterFeatures.countAsterisk(fileData);
                pw.print(input);
                pw.print(",");
                
                pw1.print(input);
                pw1.print(",");
                
                
//                countQuestion
                input = CharacterFeatures.countQuestion(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
               
//              countDollar
                input = CharacterFeatures.countDollar(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countEqual
                input = CharacterFeatures.countEqual(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
//                countDigit
                input = CharacterFeatures.countDigit(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//                countSlash
                input = CharacterFeatures.countSlash(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//                countleftparacthesis
                input = CharacterFeatures.countLeftParenthesis(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countRightParanthesis
                input = CharacterFeatures.countRightParenthesis(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countleft
                    input= CharacterFeatures.countLeftCurlyBrace(fileData);
                pw.print(input);
                                pw1.print(input);

                pw.print(",");
                                pw1.print(",");

                                
//      countright            
        
                input = CharacterFeatures.countRightCurlyBrace(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countLeftSquare
                input = CharacterFeatures.countLeftSquareBrace(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countRightSqure
                input = CharacterFeatures.countRightSquareBrace(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countPercent
                input =  CharacterFeatures.countPercent(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countPlus
                input = CharacterFeatures.countPlus(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countTab
                input = CharacterFeatures.countTab(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                
           
//                countSingleQuote
                input = CharacterFeatures.countSingleQuote(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                
//                countPeriod
                input = CharacterFeatures.countPeriod(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(","); 
                
                
//              countExclamation
                input = CharacterFeatures.countExclamation(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//                countEllipsis
                input = CharacterFeatures.countEllipsis(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");

                
//              CountHyphen
                input = CharacterFeatures.countHyphen(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                
                
//                count Comma
                input = CharacterFeatures.countComma(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
                
//                countColon
                input = CharacterFeatures.countColon(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//              CountBrace                
                input = CharacterFeatures.countColon(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");                
/////////////////////////////////////////////
                //"count_of_apostrophe":
                // pw.print(CharacterFeatures.countSingleQuote(fileData));
                // pw.print(",");

                
//                countNonWhiteSpace
                input = CharacterFeatures.countNonWhitespace(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countChar
                input = CharacterFeatures.countChar(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                percentUpper
                input = CharacterFeatures.percentUpper(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//             percentDigit
                input = CharacterFeatures.percentDigit(fileData);
                pw.print(input);
                pw.print(",");
                
                pw1.print(input);
                pw1.print(",");
                
                
//                count PercentTab
                input = CharacterFeatures.percentTab(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                
//                percentSpecialChar
               input = CharacterFeatures.percentSpecialChar(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
               
                
                
                
//              percentDigit
                input = CharacterFeatures.percentDigit(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//               percentwhitespace
                input = CharacterFeatures.percentWhitespace(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//                percentCertainty
                pw1.print(CharacterFeatures.countPercOfCertainty(fileData));
                pw1.print(",");
/////////////

//              countPercOfNegation
                input = CharacterFeatures.countPercOfNegations(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//                countPercOfAssdents
                input = CharacterFeatures.countPercOfAssents(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
//              countAverageWordLength
                pw1.print(CharacterFeatures.countAvgWordLength(fileData));
                pw1.print(",");

//                        pw.print(CharacterFeatures.uniqueWords(fileData));
//                        pw.print(",");
                ///
//                countwords
                pw1.print(CharacterFeatures.countWords(fileData));
                pw1.print(",");

                
//                totalSentences
                input = CharacterFeatures.totalSentences(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                

//                percOfQuestionedSentences
                input = CharacterFeatures.percOfQuestionedSentences(fileData);
                
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                
//                percOfWordsWithLength3
                input  = CharacterFeatures.percOfWordsWithLength3(fileData);
                
                pw.print(input);
                pw.print(",");
                
                pw1.print(input);
                pw1.print(",");
                //
// percOfWordsWithLength4
            
                input  = CharacterFeatures.percOfWordsWithLength4(fileData);
                
                pw.print(input);
                pw.print(",");
                
                pw1.print(input);
                pw1.print(",");

//                        pw.print(CharacterFeatures.avgSenetenceLength(fileData));
//                        pw.print(",");
       

// honoreRMeasure
                input = CharacterFeatures.honoreRMeasure(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
//brunetWMeasure
                input = CharacterFeatures.brunetWMeasure(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
// yulek
                input = CharacterFeatures.yuleK(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                hapax
                input = CharacterFeatures.hapaxLegomena(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countPipe
                 input = CharacterFeatures.countPipe(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countemoji
                input =CharacterFeatures.countEmoji(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//              averageEmoji
                input = CharacterFeatures.averageEmojiPerMessage(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countENGLISH
                input = CharacterFeatures.countEnglish(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
//                countRoman
                input = CharacterFeatures.countRoman(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
                
//                percentEnglish
                input = CharacterFeatures.percentEngish(fileData);
                pw.print(input);
                pw.print(",");

                pw1.print(input);
                pw1.print(",");
//                percent Roman
                input = CharacterFeatures.percentRoman(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
               
// English to roman
                input = CharacterFeatures.ratioEnglishToRoman(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
//                count slang
                input = CharacterFeatures.countSlang(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
//              percentage of slang
                input = CharacterFeatures.percentSlang(fileData);
//             diable for gender
//                pw.print(input);
//                pw.print(",");
//                
                pw1.print(input);
                pw1.print(",");
//                countAEnding
                input = CharacterFeatures.countAEnding(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");

//count IEnding
                input =  CharacterFeatures.countIEnding(fileData);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
//                ratio of A o I
                
                pw1.print(CharacterFeatures.ratioAEndingsToIEndings(fileData));
                pw1.print(",");

//                        pw.print(CharacterFeatures.mostCommonConsonants(fileData, 5));
//                        pw.print(",");
//                        pw.print(CharacterFeatures.countNGramsFromString(fileData, 1));
//                         pw.print(",");
//                        
//                        pw.print(CharacterFeatures.countNGramsFromString(fileData, 2));
//                         pw.print(",");
//                       
//                         pw.print(CharacterFeatures.countCharNGramsFromString(fileData, 5));
//                        pw.print(",");
//                       
//                        pw.print(CharacterFeatures.countCharNGramsFromString(fileData, 6));
//                       pw.print(",");
//                       
//                       pw.print(CharacterFeatures.countCharNGramsFromString(fileData, 7));
//                        pw.print(",");
//                       
//                        pw.print(CharacterFeatures.countCharNGramsFromString(fileData, 8));
//                        pw.print(",");

// CountUniquwWordNGrams
                input = CharacterFeatures.countUniqueWordNGramsFromString(fileData, 1);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
                input = CharacterFeatures.countUniqueWordNGramsFromString(fileData, 2);
                pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");

                
                input = (CharacterFeatures.countUniqueCharNGramsFromString(fileData, 5));
                  pw.print(input);
                pw.print(",");
                pw1.print(input);
                pw1.print(",");
                
                
                
                
                
            input = (CharacterFeatures.countUniqueCharNGramsFromString(fileData, 6));
//                  pw.print(input);
//                pw.print(",");
                pw1.print(input);
                pw1.print(",");
    
                
                
//                pw.print(CharacterFeatures.countUniqueCharNGramsFromString(fileData, 7));
//                pw.print(",");

                input = (CharacterFeatures.countUniqueCharNGramsFromString(fileData, 7));
                pw.print(input);
                pw.print(",");
//                pw1.print(input);
//                pw1.print(",");
                
                
                input = (CharacterFeatures.countUniqueCharNGramsFromString(fileData, 8));
//                pw.print(input);
//                pw.print(",");
//                pw1.print(input);
//                pw1.print(",");

                pw.print("?");
                pw1.print("?");
                pw.println();
                pw1.println();
            }
			
            pw.close();
		pw1.close();
		//	return creatingArff(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
		
    }

    public static String creatingArff(String data) throws FileNotFoundException, IOException {
        return preferedArff(data.split(".txt")[0] + ".arff");
//        preferedArff("Gender.arff");
    }

    public static String preferedArff(String fileName) throws FileNotFoundException, IOException {
        PrintWriter pw = new PrintWriter(fileName);
        pw.println("@Relation data");
        pw.println("");
        pw.println("");
        Scanner scanner =  null;
        if (fileName.toLowerCase().equals("age.arff")) {
                scanner = new Scanner(new File("agefeatures.txt"));
        }
        else{
                scanner = new Scanner(new File("genderfeatures.txt"));
        }
        
        while (scanner.hasNext()) {
            pw.println("@ATTRIBUTE " + scanner.nextLine() + " NUMERIC");
        }
        if (fileName.toLowerCase().equals("age.arff")) {
            pw.println("@ATTRIBUTE class{15-19,20-24,25-xx}");
        } else {
            pw.println("@ATTRIBUTE class{male,female}");
        }
        pw.println();
        pw.println("@Data");
        pw.println("\n");
        String d = "";
        if (fileName.toLowerCase().equals("age.arff")) {
               d = new File("File2.txt").getAbsolutePath();
        }
        else{
                d = new File("File.txt").getAbsolutePath();
        }
        pw.println(new String(Files.readAllBytes(Paths.get(d))));
        pw.close();
//        System.out.println("Absolute Path Of File:" + fileName + "::" + new File(fileName).getAbsolutePath());
        return new File(fileName).getAbsolutePath();
    }
    
    public static void ARFFtoCSV(String modelPath, String arffPath, String csvPath, int type){
        if (type != 1 && type != 2) {
            System.out.println("Cannot make CSV: Invalid type");
            return;
        }
        try {
            // Load Arff file
            BufferedReader reader = new BufferedReader(new FileReader(arffPath));
            ArffReader arff = new ArffReader(reader);
            Instances data = arff.getData();
            data.setClassIndex(data.numAttributes() - 1);
            
            // Load Model
            Classifier model = (Classifier) SerializationHelper.read(new FileInputStream(modelPath));
            
            // Evaluation
            Evaluation eval = new Evaluation(data);
            eval.evaluateModel(model, data);
            ArrayList<Prediction> predictedList = eval.predictions();
            
            // print summary
            System.out.println("=====" + ((type == 1) ? "Gender" : "Age") + "=====");
            System.out.println(eval.toSummaryString());
            System.out.println();
            
            // make directory if needed
            File f = new File(csvPath);
            if (f.getParentFile() != null && !f.getParentFile().exists())
                f.getParentFile().mkdirs();
            
            PrintStream oldOut = System.out;
            // CSV as output
            System.setOut(new PrintStream(f));
            System.out.println("Test_Author_Profile_Id, " + ((type == 1) ? "Gender" : "Age"));
            int count = 1;
            for (Prediction p: predictedList) {
                System.out.print("Test-Document-" + String.format("%03d", count++) + ", " );
                if (type == 1)
                    System.out.println((p.predicted() == 0d) ? "male" : "female");
                else {
                    System.out.println((p.predicted() == 0) ? "15-19" : (p.predicted() == 1) ? "20-24" : "25-xx");
                }
            }
            
            System.setOut(oldOut);
            
            System.out.println("Predictions saved: " + csvPath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
