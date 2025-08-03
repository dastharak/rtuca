/**
 * This code is adapted from the JavaScript found at:
 * https://ucsc.cmb.ac.lk//ltrl/services/feconverter/t2.html
 * No modification is done to the processing rules.
 * @author Dasun T. Bamunuarachchi

SinGlish-To-Sinhala-Unicode
----------------------------
Lu-ළු-එළු
Loo-ළූ-ළූණු
bhuu-භූ-භූතයා
jha-ඣ-ඣාන
dha-ධ-ධනය
a\n-අං-අංගොඩ
a\h-අඃ-අඃ!
GNa-ඥ-ඥානය
KNa-ඤ-විඤ්ඤාණ
nnda-ඬ-හඬ
nndha-ඳ-හඳ
nnga-ඟ-ගඟ
Dha-ඪ-ගූඪ
sru-සෘ-සෘතිය
gruu-ගෲ-ගෲෂා
Ba-ඹ-අඹ
pr-ප්‍ර-ප්‍රථම
pri-ප්‍රි-ප්‍රිය
Pa-ඵ-ඵල
Da-ඩ-මඩ
Ta-ට-කට
kha-ඛ-ඛණික

Roman-Pali-Symbols
-------------------------

-a - ā - vipāka
\m - ṃ - mānasaṃ (U+1E43)
\l - ḷ - (U+1E37)
~n - ñ - viññāna(U+00F1)
\n - ṇ - (U+1E47)
!n - ṅ - (U+1E45)


 */
public class RTUC_T2{

	public RTUC_T2(){
		init();
	}

	String text;
	int nVowels;
	String[] consonants = new String[46];
	String[] consonantsUni = new String[46];
	String[] vowels = new String[26];
	String[] vowelsUni = new String[26];
	String[] vowelModifiersUni= new String[26];
	String[] specialConsonants= new String[6];
	String[] specialConsonantsUni= new String[6];
	String[] specialChar= new String[2];
	String[] specialCharUni= new String[2];

void init(){
    vowelsUni[0]="ඌ";    vowels[0]="oo";    vowelModifiersUni[0]="ූ";
	vowelsUni[1]="ඕ";    vowels[1]="o\\)";    vowelModifiersUni[1]="ෝ";
	vowelsUni[2]="ඕ";    vowels[2]="oe";    vowelModifiersUni[2]="ෝ";
    vowelsUni[3]="ආ";    vowels[3]="aa";    vowelModifiersUni[3]="ා";
	vowelsUni[4]="ආ";    vowels[4]="a\\)";    vowelModifiersUni[4]="ා";
	vowelsUni[5]="ඈ";    vowels[5]="Aa";    vowelModifiersUni[5]="ෑ";
	vowelsUni[6]="ඈ";    vowels[6]="A\\)";    vowelModifiersUni[6]="ෑ";
	vowelsUni[7]="ඈ";    vowels[7]="ae";    vowelModifiersUni[7]="ෑ";
    vowelsUni[8]="ඊ";    vowels[8]="ii";    vowelModifiersUni[8]="ී";
	vowelsUni[9]="ඊ";    vowels[9]="i\\)";    vowelModifiersUni[9]="ී";
	vowelsUni[10]="ඊ";    vowels[10]="ie";    vowelModifiersUni[10]="ී";
    vowelsUni[11]="ඊ";    vowels[11]="ee";    vowelModifiersUni[11]="ී";
    vowelsUni[12]="ඒ";    vowels[12]="ea";    vowelModifiersUni[12]="ේ";
	vowelsUni[13]="ඒ";    vowels[13]="e\\)";    vowelModifiersUni[13]="ේ";
	vowelsUni[14]="ඒ";    vowels[14]="ei";    vowelModifiersUni[14]="ේ";
    vowelsUni[15]="ඌ";    vowels[15]="uu";    vowelModifiersUni[15]="ූ";
	vowelsUni[16]="ඌ";    vowels[16]="u\\)";    vowelModifiersUni[16]="ූ";
	vowelsUni[17]="ඖ";    vowels[17]="au";    vowelModifiersUni[17]="ෞ";
	vowelsUni[18]="ඇ";    vowels[18]="/a";    vowelModifiersUni[18]="ැ";
    vowelsUni[19]="අ";    vowels[19]="a";    vowelModifiersUni[19]="";
    vowelsUni[20]="ඇ";    vowels[20]="A";    vowelModifiersUni[20]="ැ";
    vowelsUni[21]="ඉ";    vowels[21]="i";    vowelModifiersUni[21]="ි";
    vowelsUni[22]="එ";    vowels[22]="e";    vowelModifiersUni[22]="ෙ";
    vowelsUni[23]="උ";    vowels[23]="u";    vowelModifiersUni[23]="ු";
    vowelsUni[24]="ඔ";    vowels[24]="o";    vowelModifiersUni[24]="ො";
    vowelsUni[25]="ඓ";    vowels[25]="I";    vowelModifiersUni[25]="ෛ";
    nVowels=26;

	specialConsonantsUni[0]="ං"; specialConsonants[0]="\\"+"n";//"/\\n/g";
    specialConsonantsUni[1]="ඃ"; specialConsonants[1]="\\"+"h";//"/\\h/g";
    specialConsonantsUni[2]="ඞ"; specialConsonants[2]="\\"+"N";//"/\\N/g";
    specialConsonantsUni[3]="ඍ"; specialConsonants[3]="\\"+"R";//"/\\R/g";
    //special characher Repaya
    specialConsonantsUni[4]="ර්"+'\u200D'; specialConsonants[4]="/R";//"/R/g";
    specialConsonantsUni[5]="ර්"+'\u200D'; specialConsonants[5]="\r";//"/\\r/g";

    consonantsUni[0]="ඬ"; consonants[0]="nnd";
    consonantsUni[1]="ඳ"; consonants[1]="nndh";
    consonantsUni[2]="ඟ"; consonants[2]="nng";
    consonantsUni[3]="ථ"; consonants[3]="th";
    consonantsUni[4]="ධ"; consonants[4]="dh";
    consonantsUni[5]="ඝ"; consonants[5]="gh";
    consonantsUni[6]="ඡ"; consonants[6]="ch";
    consonantsUni[7]="ඵ"; consonants[7]="ph";
    consonantsUni[8]="භ"; consonants[8]="bh";
    consonantsUni[9]="ඣ"; consonants[9]="jh";
    consonantsUni[10]="ෂ"; consonants[10]="sh";
    consonantsUni[11]="ඥ"; consonants[11]="GN";
    consonantsUni[12]="ඤ"; consonants[12]="KN";
    consonantsUni[13]="ළු"; consonants[13]="Lu";
    consonantsUni[14]="ඛ"; consonants[14]="kh";
    consonantsUni[15]="ඨ"; consonants[15]="Th";
    consonantsUni[16]="ඪ"; consonants[16]="Dh";

    consonantsUni[17]="ශ"; consonants[17]="S";
    consonantsUni[18]="ද"; consonants[18]="d";
    consonantsUni[19]="ච"; consonants[19]="c";
    consonantsUni[20]="ත"; consonants[20]="t";
    consonantsUni[21]="ට"; consonants[21]="T";
    consonantsUni[22]="ක"; consonants[22]="k";
    consonantsUni[23]="ඩ"; consonants[23]="D";
    consonantsUni[24]="න"; consonants[24]="n";
    consonantsUni[25]="ප"; consonants[25]="p";
    consonantsUni[26]="බ"; consonants[26]="b";
    consonantsUni[27]="ම"; consonants[27]="m";
    consonantsUni[28]="‍ය"; consonants[28]= "\\y";
    consonantsUni[29]="‍ය"; consonants[29]="Y";
    consonantsUni[30]="ය"; consonants[30]="y";
    consonantsUni[31]="ජ"; consonants[31]="j";
    consonantsUni[32]="ල"; consonants[32]="l";
    consonantsUni[33]="ව"; consonants[33]="v";
    consonantsUni[34]="ව"; consonants[34]="w";
    consonantsUni[35]="ස"; consonants[35]="s";
    consonantsUni[36]="හ"; consonants[36]="h";
    consonantsUni[37]="ණ"; consonants[37]="N";
    consonantsUni[38]="ළ"; consonants[38]="L";
    consonantsUni[39]="ඛ"; consonants[39]="K";
    consonantsUni[40]="ඝ"; consonants[40]="G";
    consonantsUni[41]="ඵ"; consonants[41]="P";
    consonantsUni[42]="ඹ"; consonants[42]="B";
    consonantsUni[43]="ෆ"; consonants[43]="f";
    consonantsUni[44]="ග"; consonants[44]="g";
    //last because we need to ommit this in dealing with Rakaransha
    consonantsUni[45]="ර"; consonants[45]="r";

    specialCharUni[0]="ෲ"; specialChar[0]="ruu";
    specialCharUni[1]="ෘ"; specialChar[1]="ru";
    //specialCharUni[2]="්‍ර"; specialChar[2]="ra";
}

String stringToConvert = "";
boolean debugEnable = true;
CONVERSION conType = CONVERSION.SinGlish;

enum CONVERSION{SinGlish,Pāli};

public void setStringToConvert(String s){
	stringToConvert = s;
}

public String getStringToConvert(){
	return stringToConvert;
}

String getConversionTable(){
	if(conType == CONVERSION.SinGlish){
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}else{
		return "";//TODO implement
	}
}

String processText(){
	if(conType == CONVERSION.SinGlish){
		return processTextES();
	}else{
		return processTextPāli();
	}
}

String processTextPāli(){
	return "";
}

String processTextES() {
    String s,r,v;
    String text = stringToConvert;
    //special consonants
    for (int i=0; i<specialConsonants.length; i++){
		text = text.replace(specialConsonants[i], specialConsonantsUni[i]);
	}
	if(debugEnable)System.out.println("special consonants:"+text);
    //consonants + special Chars
    for (int i=0; i<specialCharUni.length; i++){
        for (int j=0;j<consonants.length;j++){
            s = consonants[j] + specialChar[i];
            v = consonantsUni[j] + specialCharUni[i];
            //r = new RegExp(s,"g");
            text = text.replace(s, v);
        }
    }
	if(debugEnable)System.out.println("consonants + special Chars:"+text);
    //consonants + Rakaransha + vowel modifier
	for (int j=0;j<consonants.length;j++){
        for (int i=0;i<vowels.length;i++){
            s = consonants[j] + "r" + vowels[i];
            v = consonantsUni[j] + "්‍ර" + vowelModifiersUni[i];
            //r = new RegExp(s,"g");
            text = text.replace(s, v);
        }
        s = consonants[j] + "r";
        v = consonantsUni[j] + "්‍ර";
        //r = new RegExp(s,"g");
        text = text.replace(s, v);
    }
	if(debugEnable)System.out.println("consonants + Rakaransha + vowel modifier:"+text);

    //consonants + vowel modifiers
    for (int i=0;i<consonants.length;i++){
        for (int j=0;j<nVowels;j++){
			if("".equals(vowels[j])){
				continue;//skip combinations if unused
			}
            s = consonants[i] + vowels[j];
            v = consonantsUni[i] + vowelModifiersUni[j];
            //r = new RegExp(s,"g");
            text = text.replace(s, v);
        }
    }
	if(debugEnable)System.out.println("consonants + vowel modifiers:"+text);
    //consonants + HAL
    for (int i=0; i<consonants.length; i++){
        //r = new RegExp(consonants[i],"g");
        text = text.replace(consonants[i], consonantsUni[i]+"්");
    }
    if(debugEnable)System.out.println("consonants + HAL:"+text);
    //vowels
    for (int i=0; i<vowels.length; i++){
        //r = new RegExp(vowels[i],"g");
        text = text.replace(vowels[i], vowelsUni[i]);
    }
	if(debugEnable)System.out.println("vowels:"+text);

    stringToConvert = text;//side effect
	return text;
}

	public static void main(String[] args){
		RTUC_T2 rtuc = new RTUC_T2();
		String concat = "";
		for(String s : args){
			concat+=s+" ";
		}
		rtuc.setStringToConvert(concat);

		System.out.println("\nIn :"+rtuc.getStringToConvert());

		rtuc.processText();

		System.out.println("\nOut:"+rtuc.getStringToConvert());
	}
}
