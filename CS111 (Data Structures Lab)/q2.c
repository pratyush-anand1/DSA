#include <stdio.h>
#include <stdlib.h>

#define SIZE 10

struct DataItem {
   int data;   
   int key;
};

struct DataItem* hashArray[SIZE]; 
struct DataItem* dup;
struct DataItem* item;

int hashCode(int key) {
   return key % SIZE;
}

struct DataItem *search(int key) {
   int hashIndex = hashCode(key);  
	
   while(hashArray[hashIndex] != NULL) {
	
      if(hashArray[hashIndex]->key == key)
         return hashArray[hashIndex]; 
       
      ++hashIndex;
		
      
      hashIndex %= SIZE;
   }        
	
   return NULL;        
}

void insert(int key,int data) {

   struct DataItem *item = (struct DataItem*) malloc(sizeof(struct DataItem));
   item->data = data;  
   item->key = key;

  
   int hashIndex = hashCode(key);

   
   while(hashArray[hashIndex] != NULL && hashArray[hashIndex]->key != -1) {
      
      ++hashIndex;
		
     
      hashIndex %= SIZE;
       }
	
   hashArray[hashIndex] = item;
}

struct DataItem* delete(struct DataItem* item) {
   int key = item->key;

  
   int hashIndex = hashCode(key);

   
   while(hashArray[hashIndex] != NULL) {
	
      if(hashArray[hashIndex]->key == key) {
         struct DataItem* temp = hashArray[hashIndex]; 
			
         
         hashArray[hashIndex] = dup; 
         return temp;
      }
		
      
      ++hashIndex;
       hashIndex %= SIZE;
   }      
	
   return NULL;        
}

int main() {
   dup = (struct DataItem*) malloc(sizeof(struct DataItem));
   dup->data = -1;  
   dup->key = -1; 
   int arr1[]={2,5,6,8,10,2,2};
   int arr2[]={2,5,5,8,10,5,6};
   for(int i=0;i<7;i++){
    insert(i,arr1[i]);
   }
   int j=0;
   while(j <= 7){
    item=search(arr2[j]);
    if(item!=NULL){ 
        delete(item);
        j++;
        continue;
    }
    else if(item==NULL){
        printf("Both arrays don't have same elements.");
        break;
    }
    if(j==7){
        printf("Both arrays have same elements.");
    }
   }
   return 0;
}