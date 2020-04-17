public static void longestName(Scanner input,int n){
        String greaterName = "";
        boolean tie = false;

        for (int i = 1; i <= n ; i++) {
            System.out.print("name #" + i + "? ");
            String name = input.next();
            if(name.length() > greaterName.length()){
                greaterName = name;
                tie = false;
                continue;
            }
            if (name.length() == greaterName.length()){
                tie = true;
            }

        }
        greaterName = greaterName.toLowerCase();
        greaterName = greaterName.substring(0, 1).toUpperCase() + greaterName.substring(1);
        System.out.print(greaterName + "'s name is longest");

        if(tie){
            System.out.print("\n(There was a tie!)");
        }
    }
