import java.util.Scanner;

/**
 * hello
 */
public class exam {

    static String userString = new String();
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        System.out.println("Please enter the calculation you want to make:");
        userString = tarayici.nextLine();
        userString=userString.replaceAll("\\s+", "");
        char[] userStringArray=new char[userString.length()];
        userStringArray=userString.toCharArray();
        int[] sayilar=new int[1];
        int[] sayilarGecici=new int[1];
        int[] islemlerOnceliksiz=new int[1];
        int[] islemlerOnceliksizGecici=new int[1];
        int[] islemlerOncelikli=new int[1];
        int[] islemlerOncelikliGecici=new int[1];
        while(toplamaCikarmaBul(userString)){
            for (int i=0;i<userStringArray.length;i++){
                if(userStringArray[i]=='1' ||userStringArray[i]=='2' ||userStringArray[i]=='3' ||userStringArray[i]=='4' ||userStringArray[i]=='5' ||userStringArray[i]=='6' ||userStringArray[i]=='7' ||userStringArray[i]=='8' ||userStringArray[i]=='9' ||userStringArray[i]=='0' ){
                    sayilarGecici[sayilarGecici.length-1]=i;
                    sayilar=sayilarGecici;
                    sayilarGecici = new int[sayilar.length+1];
                    for (int j=0;j<sayilar.length;j++) {
                        sayilarGecici[j]=sayilar[j];
                    }
                }
                if(userStringArray[i]=='*' ||userStringArray[i]=='/' ){
                    islemlerOncelikliGecici[islemlerOncelikliGecici.length-1]=i;
                    islemlerOncelikli=islemlerOncelikliGecici;
                    islemlerOncelikliGecici = new int[islemlerOncelikli.length+1];
                    for (int j=0;j<islemlerOncelikli.length;j++) {
                        islemlerOncelikliGecici[j]=islemlerOncelikli[j];
                    }
                }
                if(userStringArray[i]=='+' ||userStringArray[i]=='-' ){
                    islemlerOnceliksizGecici[islemlerOnceliksizGecici.length-1]=i;
                    islemlerOnceliksiz=islemlerOnceliksizGecici;
                    islemlerOnceliksizGecici = new int[islemlerOnceliksiz.length+1];
                    for (int j=0;j<islemlerOnceliksiz.length;j++) {
                        islemlerOnceliksizGecici[j]=islemlerOnceliksiz[j];
                    }
                }
            }
            if(!carpmaBolmeBul(userString)){
                userString=islemGerceklestir(userStringArray, islemlerOnceliksiz[0]);
                userStringArray=userString.toCharArray();
                System.out.println(userString);
            }
            while(carpmaBolmeBul(userString)){
                userString=islemGerceklestir(userStringArray, islemlerOncelikli[0]);
                userStringArray=userString.toCharArray();
                System.out.println(userString);
            
            }
                
        }
    }

    public static String islemGerceklestir(char[] userInput,int islemIndeks){
        int sonuc = 0;
        StringBuilder yeniString = new StringBuilder(64);

        if(userInput[islemIndeks]=='*'){
            int a=Character.getNumericValue(userInput[islemIndeks-1]);
            int b=Character.getNumericValue(userInput[islemIndeks+1]);
            sonuc=a*b;
        }else if (userInput[islemIndeks]=='/'){
            int a=Character.getNumericValue(userInput[islemIndeks-1]);
            int b=Character.getNumericValue(userInput[islemIndeks+1]);
            sonuc=a/b;
        }else if (userInput[islemIndeks]=='+'){
            int a=Character.getNumericValue(userInput[islemIndeks-1]);
            int b=Character.getNumericValue(userInput[islemIndeks+1]);
            sonuc=a+b;
        }else if(userInput[islemIndeks]=='-'){
            int a=Character.getNumericValue(userInput[islemIndeks-1]);
            int b=Character.getNumericValue(userInput[islemIndeks+1]);
            sonuc=a-b;
        }
        char[] sonucArray1=new char[islemIndeks-1];
        for (int i = 0;i<sonucArray1.length;i++){
            sonucArray1[i]=userInput[i];
        }
        char[] sonucArray2=new char[userInput.length-sonucArray1.length-3];
        for (int i = 0;i<sonucArray2.length;i++){
            sonucArray2[i]=userInput[islemIndeks+i+2];
        }
        
        yeniString.append(sonucArray1);
        yeniString.append(sonuc);
        yeniString.append(sonucArray2);
        
        
        return yeniString.toString();
    }


    public static boolean toplamaCikarmaBul(String userInput){
        char[] userInputString=new char[userInput.length()];
          
        userInputString=userInput.toCharArray();
        for (char c : userInputString) {
            if(c=='+'||c=='-'){
                return true;
            }
        }
        return false;
    }
    public static boolean carpmaBolmeBul(String userInput){
        char[] userInputString=new char[userInput.length()];
        
        userInputString=userInput.toCharArray();
        for (char c : userInputString) {
            if(c=='*' || c=='/'){
                return true;
            }
        }
        return false;
    }
    //for future use
    public static boolean parantezBul(String userInput){

        char[] userInputString=new char[userInput.length()];
        
        userInputString=userInput.toCharArray();

        for (char c : userInputString) {
            if(c=='(' || c==')'){
                return true;
            }
        }
        return false;
    }
}