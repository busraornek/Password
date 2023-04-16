import java.util.Scanner;


public class Generator {
	Alphabet alphabet;
	public static Scanner keyboard;
	
	public Generator(Scanner scanner) {
		keyboard = scanner;	
	}
	
	public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }
	 public void mainLoop() {
		 
	      System.out.println("Password Servisine Hoşgeldiniz!");
	        
	      printUsefulInfo();
	        
	      printMenu();
	      
	      String userOption = "-1";
	      
	      while(!userOption.equals("3")) {
	    	  userOption = keyboard.next();
	    	  switch(userOption) {
	    	    case "1" -> {
	    	    	requestPassword();
	    	    	printMenu();
	    	    }
	    	    case"2" -> {
	    	    	checkPassword();
	    	    	printMenu();
	    	    	
	    	    }
	    	    case "3" -> printQuitMessage();
	    	    default -> {
	    	    	 System.out.println();
	                    System.out.println("Lütfen mevcut komutlardan birini seçin!");
	                    printMenu();
	    	    }
	    	  }
	    	  
	      }
	     
	        
	 }
	 private Password GeneratePassword(int length) {
		 final StringBuilder pass = new StringBuilder("");
		 
		 final int alphabetLength = alphabet.getAlphabet().length();
		 
		 int max = alphabetLength -1;
		 int min = 0;
		 int range = max - min +1 ;
		 for(int i=0; i < length; i++) {
			 int index = (int) (Math.random() * range) +min;
			 pass.append(alphabet.getAlphabet().charAt(index));
			 
		 }
		 return new Password(pass.toString());
		 
	 }
	 private void requestPassword() {
		 boolean IncludeUpper = false;
		 boolean IncludeLower = false;
		 boolean IncludeNum = false;
		 boolean IncludeSym = false;
		 
		 boolean correctParams;
		 System.out.println();
		 System.out.println("Merhaba, Şifre Oluşturucuya hoş geldiniz ,Aşağıdaki soruları 'evet' veya 'hayır' olarak cevaplayın");
         
		 do {
			 String input;
			 correctParams = false;
			   do {
				   System.out.println("Küçük harflerin \"abcd...\" kullanılmasını istiyor musunuz? ");
				   input = keyboard.next();
				   PasswordRequestError(input);
				   
			   }
			   while(!input.equalsIgnoreCase("evet") && !input.equalsIgnoreCase("hayır"));
			   
			   if (isInclude(input)) IncludeLower = true;
				   
			   do {
				 System.out.println("Büyük \"ABCD...\" harflerinin kullanılmasını istiyor musunuz? ");
				 input = keyboard.next();
				 PasswordRequestError(input);
				   
			   }while (!input.equalsIgnoreCase("evet") && !input.equalsIgnoreCase("hayır"));

	            if (isInclude(input)) IncludeUpper = true;
	            do {
	            	 System.out.println("\"1234...\" Numaralarının kullanılmasını istiyor musunuz? ");
	 	            input = keyboard.next();
	 	            PasswordRequestError(input);
	            } while (!input.equalsIgnoreCase("evet") && !input.equalsIgnoreCase("hayır"));

	            if (isInclude(input)) IncludeNum = true;
	            do {
		            System.out.println("Sembollerin \"!@#$...\" kullanılmasını istiyor musunuz? ");
		            input = keyboard.next();
		            PasswordRequestError(input);
		            } while (!input.equalsIgnoreCase("evet") && !input.equalsIgnoreCase("hayır"));

		            if (isInclude(input)) IncludeSym = true;
                     
		            if(!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
		            	 System.out.println("Parolanızı oluşturmak için hiçbir karakter seçmediniz, yanıtlarınızdan en az biri Evet olmalıdır\\n");
			                correctParams = true;
		            }

		 }
		 while(correctParams);
		 System.out.println("Şimdi şifrenin uzunluğunu girin");
	        int length = keyboard.nextInt();
	        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	        final Password password = generator.GeneratePassword(length);

	        System.err.println("Şifreniz -> " + password);
		 
		 }
	 
		 private boolean isInclude(String Input) {
			 if(Input.equalsIgnoreCase("evet")) {
				 return true;
			 }
			 else {
				 return false;
			 }
		 }
		 
	 
	 //girilen ifade evet veya hayır değilse, büyük küçük harf fark etmemesi için equalsIgnoreCase() method kullanıldı.
		 
	 private void PasswordRequestError(String i) {
		 if (!i.equalsIgnoreCase("evet") && !i.equalsIgnoreCase("hayır")) {
			  System.out.println("Yanlış bir şey girdiniz, tekrar deneyiniz.");
		 }
		 
	 }
    private void printUsefulInfo() {
	  System.out.println();
      System.out.println("Minimum 8 veya daha fazla karakter uzunluğunda bir parola kullanın.");
      System.out.println("Küçük ve büyük alfabetik karakterleri, sayıları ve sembolleri dahil edin.");
      System.out.println("Mümkün olduğunda rastgele şifreler oluşturun");
      System.out.println("Aynı parolayı iki kez kullanmaktan kaçının (ör. birden çok kullanıcı hesabında ve/veya yazılım sisteminde)");
      System.out.println("Karakter tekrarından, klavye kalıplarından, sözlük sözcüklerinden, harf veya sayı dizilerinden," +
      " kullanıcı adlarından, akraba veya evcil hayvan adlarından,"+
     "romantik bağlantılardan (şimdiki veya geçmiş) ve biyografik bilgilerden (ör. kimlik numaraları, ata adları veya tarihleri) kaçının.");
      System.out.println("Kullanıcının iş arkadaşlarının ve/veya tanıdıklarının " +
              "kullanıcıyla ilişkili olduğunu bilebilecekleri bilgileri kullanmaktan kaçının.");
      System.out.println("Tamamen yukarıda belirtilen zayıf bileşenlerin herhangi bir basit kombinasyonundan oluşan şifreler kullanmayın.");
  
	  
  }
  private void checkPassword() {
	  String input;
	  System.out.print("\nŞifrenizi girin:");
      input = keyboard.next();
      
      final Password p = new Password(input);
      
      System.out.println(p.calculateScore());
  }
	  
  private void printMenu() {
	  System.out.println();
	  System.out.println("Enter 1 - Password Oluşturucu");
	  System.out.println("Enter 2 - Password Gucunu Test Et");
	  System.out.println("Enter 3 - Cikis");
	  System.out.println("Secenek: ");
	  
	
}
  private void printQuitMessage() {
      System.out.println("Program kapanıyor, Güle güle");
  }
}
