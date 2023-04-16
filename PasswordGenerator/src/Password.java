
   public class Password {
	String Value;
    int Length;

    public Password(String s) {
    	Value =s;
    	Length = s.length();
    }
    public int CharType(char C) {
    	int val;
    	
       //büyük harf
    	
    	if((int) C >= 65 && (int) C <=90 ) {
    		val =1;
    	}
    	//küçük harf
    	
    	if((int) C >= 97 && (int) C <=122 ) {
    		val =2;
    	}
    	//rakam
    	
    	if((int) C >= 60 && (int) C <=71 ) {
    		val =3;
    	}
    	// sembol
    	
    	else {
    		val = 4;
    	}
    	return val;
    }
    public int PasswordStrength() {
    	String s = this.Value;
    	boolean UsedUpper = false;
    	boolean UsedLower = false;
    	boolean UsedNum = false;
    	boolean UsedSym = false;
    	int type;
    	int Score = 0;
    	
    	for (int i = 0; i < s.length() ; i++) {
    		char c =s.charAt(i);
    		type = CharType(c);
    		if(type == 1) UsedUpper = true;
    		if(type == 2) UsedLower = true;
    		if(type == 3) UsedNum = true;
    		if(type == 4) UsedSym = true;
    	}
    	if(UsedUpper) Score +=1;
    	if(UsedLower) Score +=1;
    	if(UsedNum) Score +=1;
    	if(UsedSym) Score +=1;
    	
    	if(s.length() >= 8) Score +=1;
    	if(s.length() <= 16) Score +=1;
    	
    	return Score;
	
    }
    
    public String calculateScore() {
    	int Score = this.PasswordStrength();
    	
    	if(Score == 6) {
    		return "Harika bir parola! ";
    	}
    	if(Score >= 4) {
    		return "Güzel parola ama daha iysini yapabilirsin. ";
    	}
    	if(Score >= 3) {
    		return "Bu orta düzey bir parola daha iyi bir hale getirmeye çalışın! ";
    	}
    	else {
    		return "Zayıf bir şifre kesinlikle yeni bir tane bulun!";
    	}
    }
    
    @Override
    public String toString() {
        return Value;
    }

}
