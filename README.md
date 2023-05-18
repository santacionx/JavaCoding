# JavaCoding
dsa with java and coding
https://docs.google.com/document/d/e/2PACX-1vTkrryOX6e3BHRNu8gEjdoEoPUCupeE1pDVb2gLCr9U509vWB5bAW2N0TDGD76lFCs8vqinFS25c8kT/pub
visit this link the doc contains all the coding of java
learnt:
 patterns 
 arrays 
 strings 
 linked list
 stack 
 queue
 binary tree
 so far
 
- [x] Pointers 

- [ ] Symbol table
- [ ] pointer type*var=address ; access print(*var)
- [ ] Pointer size 8byte always ; pointer arithmetic : p+1; points to next 8th byte 
- [ ] Array: &a[0]=a =&a (both stores initial address)
- [ ] *(a+I)=a[I]
- [ ] Size of a: 40b *p=8byte
- [ ] Array can’t be reassigned: a=a+3 (no) symbol table fixed the initial address of array  

- [ ] Note: size of , & operator ,assignment  are not as same as pointer stores
- [ ]  Vs array stores 

- [ ] Character vs pointer
- [ ] 	Char c=‘a’ char *p=&c;
- [ ] 	print *p value returned //a
- [ ] 	print  p value returned upto null encountered // a?w…\0
- [ ] 	print c //a

- [ ] String vs pointer 
- [ ]    String array stored in temporary loc once assigned the storage is allocated
- [ ] 	ex char str[]=“abcd” 1. Temp space store then to str creates storage(symbol
- [ ]  Table assign) and places 
- [ ] 	ex: ch *p=“abcd” 1. Points to temp storage this  should be avoided 

- [ ] Functions vs pointer

- [ ]    Array a passed to function as pointer but this holds only 8byte/initial storage so size must be specified

- [ ] Double pointer if fun (**p) holds pointer address
