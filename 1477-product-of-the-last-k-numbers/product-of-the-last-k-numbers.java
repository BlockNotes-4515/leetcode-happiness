class ProductOfNumbers {

    int[] prefix;
    int size;

    public ProductOfNumbers() {
        prefix = new int[40001];
        size = 0;
        prefix[0] = 1;
    }
    
    public void add(int num) {
         if (num == 0) {
            size = 0;
        } 
        else {
            size++;
            prefix[size] = prefix[size - 1] * num;
        }
    }
    
    public int getProduct(int k) {
        
        if (k>size) {
            return 0;
        }
        return prefix[size] / prefix[size - k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */