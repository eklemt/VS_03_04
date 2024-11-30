public class MergeSort extends SortAndCount
{
    
    
    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + 1) return; 

        int m = lo + (hi - lo) / 2; 
        sort(a, aux, lo, m);
        sort(a, aux, m, hi);

        
        merge(a, aux, lo, m, hi);
    }

   
    private void merge(Comparable[] a, Comparable[] aux, int l, int m, int r) {
        
        for (int k = l; k < r; k++) {
            
            exchAux(a, aux, k, k);  
            //aux[k] = a[k];
        }

        int i = l, j = m;

        for (int k = l; k < r; k++) {
             
            if (i >= m) { 
               exchAux(aux, a , k, j++);
                //a[k] = aux[j++]; 
            } else if (j >= r) { 
                exchAux(aux, a , k, i++);
                //a[k] = aux[i++]; 
            } else if (less(aux[j], aux[i])) { 
                exchAux(aux, a , k, j++);
                //a[k] = aux[j++]; 
            } else {
                exchAux(aux, a , k, i++);
                //a[k] = aux[i++]; 
            }
        }
    }

    
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; 
        sort(a, aux, 0, a.length); 
    }


  

}

