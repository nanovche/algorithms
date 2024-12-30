package seeburger;

public class PackagesTask {

    private static final int maxNumOfItemsInSmallPackages = 1;
    private static final int maxNumOfItemsInLargePackages = 5;

    public static void main(String[] args) {
        System.out.println(numOfPackages(28, 6, 3));
        System.out.println(numOfPackages(14, 6, 6));
        System.out.println(numOfPackages(10, 2, 3));
        System.out.println(numOfPackages(13, 2, 3));
    }
    static int numOfPackages(int items, int numOfSmallPackages, int numOfLargePackages){

        if(!doItemsContainInPackages(items, numOfSmallPackages, numOfLargePackages)) {
            return -1;
        }
        if(numberOfItemsIsZero(items)){
            return -1;
        }

        int packageCounter = 0;
        while(checkIfCurrentNumberOfItemsIsBiggerThanFive(items)){
            items = subtractLargePackageNumberOfItems(items);
            packageCounter++;
            if(numberOfItemsIsZero(items)){
                return packageCounter;
            }
        }

        while(!numberOfItemsIsZero(items)){
            items = subtractSmallPackageNumberOfItems(items);
            packageCounter++;
        }

        return packageCounter;

    }

    static boolean numberOfItemsIsZero(int currentNumberOfItems){
        return currentNumberOfItems == 0;
    }
    static int subtractLargePackageNumberOfItems(int currentNumOfItems){
        return currentNumOfItems - maxNumOfItemsInLargePackages;
    }

    static int subtractSmallPackageNumberOfItems(int currentNumOfItems){
        return currentNumOfItems - maxNumOfItemsInSmallPackages;
    }

    static boolean checkIfCurrentNumberOfItemsIsBiggerThanFive(int numOfItems){
        return numOfItems >= maxNumOfItemsInLargePackages;
    }

    static boolean doItemsContainInPackages(int items, int numOfSmallPackages, int numOfLargePackages){
        return items <= numOfSmallPackages * maxNumOfItemsInSmallPackages + numOfLargePackages * maxNumOfItemsInLargePackages;
    }

}

/*
*  large package contains 5 items
*  small package contains 1 item
*
*  1) all items should be put in packages
*  2) no package can be half full -> for example a large package will contain 5 items or it will not contain any
*                                 -> small package will contain 1 item or it will not contain any
*
*  3) return the minimum number of packages that are needed to contain all the items or return -1 if this is not possible
* */
