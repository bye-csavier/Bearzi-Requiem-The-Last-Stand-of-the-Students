package extra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Utils {

//    public static void main(String[] args)
//    {
//        double tempA = convertTime(4,"s","ns");
//
//        System.out.println(nL + "tempA: " + tempA + nL);
//    }

    //=== NUMBERS ====================================================================================================================

    //---- Mapping Func ---------------------------------------------------------------------------------------------------------------

    public static long map(long input, long in_min, long in_max, long out_min, long out_max)
    {
        return (input - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public static double map(double input, double in_min, double in_max, double out_min, double out_max)
    {
        return (input - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public static int map(int input, int in_min, int in_max, int out_min, int out_max)
    {
        return (input - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public int clamp(int min, int value, int max)
    {
        if(value < min)
        {
            return min;
        }
        else if(value > max)
        {
            return max;
        }

        return value;
    }

    public static double clamp(double min, double value, double max)
    {
        if(value < min)
        {
            return min;
        }

        if(value > max)
        {
            return max;
        }
        return value;
    }

    //---- Random Numbers ---------------------------------------------------------------------------------------------------------------

    public static int randInt(int min, int max) // int random con limiti facili
    {
        return (int) ((Math.random() * ((max+1)-min)) + min);
    }

    public static double randDouble(double min, double max) // int random con limiti facili
    {
        return (Math.random() * ((max+1)-min)) + min;
    }

    public static boolean rarity(double rarity)
    {
        if(rarity >= 100)
        {
            return true;
        }
        else if(rarity <= 0)
        {
            return false;
        }

        rarity = rarity/2;

        double randNum = randDouble(0,100);
        //randNum += randDouble(-1,1);

        if(randNum >= (50-rarity) && randNum <= (50+rarity))
        {
            return true;
        }

        return false;

    }

    //---- Manipulate Numbers ---------------------------------------------------------------------------------------------------------------

    public static double truncate(double value, int decimalpoint) // troncaggio dei double
    {

        boolean negative = false;

        if(value < 0)
        {
            value = Math.abs(value);
            negative = true;
        }

        value = value * Math.pow(10, decimalpoint);
        value = Math.floor(value);
        value = value / Math.pow(10, decimalpoint);

        if(negative == true)
        {
            return (-value);
        }
        else
        {
            return value;
        }

    }

    public static int percentage(int value, double percentage)
    {
        return (int) ( ( ((double) value) / 100 ) * percentage);
    }

    public static int percentage(double value, double percentage)
    {
        return (int) ( ( ((double) value) / 100 ) * percentage);
    }

    public static double percentageF(double value, double percentage)
    {
        return ( ( (value) / 100 ) * percentage);
    }

    //=== STRINGS & CHARS ====================================================================================================================

    public final static String nL= System.getProperty("line.separator");

    public static String newLines(int newLinesAmt)
    {
        String str = nL;

        for(int i = 1; i < newLinesAmt; i++)
        {
            str += nL;
        }

        return str;
    }

    public static String stringSetChar(String str, char input, int index)
    {
        char[] temp = str.toCharArray();
        temp[index] = input;

        return  String.valueOf(temp);
    }

    public static String deleteLastStringChar(String str)
    {
        return str.substring(0, str.length() - 1);
    }

    public static char charToUpper(char chr) // due funzioni per trasformare i charatteri singoli
    {
        if(chr >= 'a'&& chr <= 'z')
        {
            int temp = (int) chr;
            temp -= 32;

            return ( (char) temp );
        }

        return chr;
    }

    public static char charToLower(char chr)
    {
        if(chr >= 'A'&& chr <= 'Z')
        {
            int temp = (int) chr;
            temp += 32;

            return ( (char) temp );
        }

        return chr;
    }

    public static char randAlphaChar(int upperChance) // funzione che ritorna una lettera a caso con una percentuale "upperChance" di essere maiuscola
    {
        char chr = (char) randInt(65,90);
        int whatCase = randInt(0,100);
        upperChance /= 2;

        if(whatCase > (50-upperChance) && whatCase < (50+upperChance))
        {
            return chr;
        }
        else
        {
            return charToLower(chr);
        }
    }

    public static int extractIntFromString(String str)
    {
        Scanner in = new Scanner(str).useDelimiter("[^0-9]+");

        return in.nextInt();
    }

    //=== TIME ====================================================================================================================

    public static void wait(int ms, boolean inSeconds) // funzione di sleep/wait
    {

        if(inSeconds == true)
        {
            ms = ms * 1000;
        }

        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

    }

    public static double convertTime(double fromTime, String fromTimeFormat, String toTimeFormat) //TODO
    {
		/*
			a = anno
			m = mesi
			week = settimane
			d = giorni
			h = ore
			min = minuti
			s = secondi
			ms = millisecondi
			ns = nanosecondi
		 */

        /*
			a = anno
			m = mesi
			week = settimane
			d = giorni
			h = ore
			min = minuti
			s = secondi
			ms = millisecondi
			ns = nanosecondi
		 */

        fromTimeFormat = fromTimeFormat.toLowerCase();
        toTimeFormat = toTimeFormat.toLowerCase();

        if(fromTimeFormat.equals(toTimeFormat))
        {
            return fromTime;
        }

        double convTime = fromTime;

        // Conversion to seconds cases

        if(fromTimeFormat.equals("s") == false)
        {
            switch(fromTimeFormat)
            {

                case "a" -> {
                
                    convTime = fromTime * 31557600;
                }

                case "m" -> {
                
                    convTime = fromTime * 2629800;
                }

                case "week" -> {
                
                    convTime = fromTime * 604800.02;
                }

                case "d" -> {
                
                    convTime = fromTime * 86400;
                }

                case "h" -> {
                
                    convTime = fromTime * 3600;
                }

                case "min" -> {
                
                    convTime = fromTime * 60;
                }

                case "ms" -> {
                    convTime = fromTime * 0.001;
                }

                case "ns" -> {
                    convTime = fromTime * 0.000000001;
                }

            }
        }

        // Conversion to "toTimeFormat" cases
        switch(toTimeFormat)
        {
            case "a" -> {
             
                return (convTime / 31557600);
            }

            case "m" -> {
             
                return (convTime / 2629800);
            }

            case "week" -> {
             
                return (convTime / 604800.02);
            }

            case "d" -> {
             
                return (convTime / 86400);
            }

            case "h" -> {
             
                return (convTime / 3600);
            }

            case "min" -> {
             
                return (convTime / 60);
            }

            case "ms" -> {
             
                return (convTime / 0.001);
            }

            case "ns" -> {
             
                return (convTime / 0.000000001);
            }

        }

        return convTime;
    }

    public static String getCurrentDate() // ritorna una stringa con la data corrente
    {
        LocalDate temp = java.time.LocalDate.now();
        return temp.toString();
    }

    public static String getCurrentTime() // ritorna una stringa con l'ora corrente
    {
        LocalTime temp = java.time.LocalTime.now();
        String str = temp.getHour() + ":" + temp.getMinute() + ":" + String.valueOf(truncate(temp.getSecond(),0));

        return str;
    }

}
