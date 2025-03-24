// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

public class productofArrayExceptSelf {
    public static void findproduct(int arr[], int product[],int n){
    product[0] = 1;
    for(int i = 1; i < n; i++){
        product[i] = arr[i - 1] * product[i - 1];
    }
    int R = 1;
    for(int i = n - 1; i >= 0; i--){
        product[i] = product[i] * R;
        R *= arr[i];
    }

    }
    
    public static void main(String arg[]){
        int arr[] = { 1 , 4 , 6 , 2 , 3};
        // product = [1,1,4,24,48,144];
        int n = arr.length;
        int product[]=new int[n];
        findproduct(arr,product,n);
 
        System.out.print("The product of array Except itself is: ");
        for(int i=0;i<n;i++)
        {
            System.out.print(product[i]+", "); 
        }
        System.out.println();
    }

}