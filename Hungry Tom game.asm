                                                                                       ; multi-segment executable file template.
 
data segment 
        
wait_time dw 0
double_wait dw 0
Opening db 28 dup("*")                    ,13,10
        db "*  Welcome to Hungry Tom   *" ,13,10
        db "*  Use 'a','d' to move     *" ,13,10
        db "* EAT ONLY THE RED APPLES! *" ,13,10
        db "*         ENJOY!           *" ,13,10
        db "*  Press any key to start  *" ,13,10
        db 28 dup("*"),"$"                ,13,10
  
ClearM db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)

Dagger db 0FH,4 dup(0),2 dup(06H),4 dup(0),0FH
db 0FH,4 dup(0),2 dup(06H),4 dup(0),0FH
db 0FH,4 dup(0),2 dup(06H),4 dup(0),0FH
db 0FH,4 dup(0),2 dup(06H),4 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
db 0FH,3 dup(0),4 dup(07H),3 dup(0),0FH
 
Apple db 0FH,10 dup(0),0FH
db 0FH,3 dup(0),02H,6 dup(0),0FH
db 0FH,2 dup(0),02H,02H,2 dup(02H),4 dup(0),0FH
db 0FH,3 dup(0),02H,02H,02H,4 dup(0),0FH
db 0FH,3 dup(0),5 dup(04H),2 dup(0),0FH
db 0FH,2 dup(0),04H,5 dup(04H),04H,0,0FH
db 0FH,0,04H,7 dup(04H),04H,0FH
db 0FH,2 dup(0),04H,5 dup(04H),04H,0,0FH
db 0FH,2 dup(0),04H,5 dup(04H),04H,0,0FH
db 0FH,3 dup(0),04H,04H,04H,04H,04H,2 dup(0),0FH
db 0FH,4 dup(0),04H,0,04H,3 dup(0),0FH
 
 
msg  db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
db 0FH,10 dup(0),0FH
 
 
Mouth db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 04 dup(0),3 dup(06H),5 dup(0)
db 03 dup(0),06H,06H,1 dup(0DH),06H,06H,4 dup(0)
db 02 dup(0),06H,06H,3 dup(0DH),06H,06H,3 dup(0)
db 03 dup(0),06H,06H,1 dup(0DH),06H,06H,4 dup(0)
db 04 dup(0),3 dup(06H),5 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
db 12 dup(0)
 
msg2 db "You have lost press any key to continue$"   
msg3 db "Do you want to play again?(y/n)$"

msg4 db "Tom is not hungry anymore thank you for playing",13,10 
     db "Do you want to play again?(y/n)$"  
Points db 00
Egame db 00
Plz db 00
Wut db 00
Num db 00
row db 12
col db 112
Prow db 96
Pcol db 136
Arow db 12
Brow db 12
Bcol db 112
ends
 
stack segment
    dw   128  dup(0)
ends
 
code segment 
    
;***************************************
;*  init_graphics summons a screen     *
;*  input : NONE                       *
;*  output: NONE                       *
;***************************************      
proc init_graphics
    push ax
    mov ax, 13H
    int 10H
    pop ax
    ret
    endp init_graphics
   
;***************************************
;*   Particle: draws a single pixel    *
;*   input : row and col               *
;*   output: NONE                      *
;***************************************
proc Particle
    mov bp, sp
    pusha
    mov bx, [bp+2]  
    mov si, [bp+4]
    mov al, bh
    xor ah, ah
    mov cx, 320
    mul cx
    xor bh, bh
    add ax, bx
    mov di, ax
    mov AX, 0A000H
    mov es, ax   
    mov cx, 13
 DRAW:
    push cx
    push di   
    mov cx, 12
    rep movsb
    pop di
    add di, 320
    pop cx
    loop DRAW
   
    popa
    ret 4
endp Particle  

;******************************************
;*   DrawOpening: Draws Opening           *
;*   input : NONE                         *
;*   output: NONE                         *
;******************************************
proc Opening_Screen
    pusha
    lea dx,Opening
    mov ah,9
    int 21h                  
    popa
    ret
endp Opening_Screen  

;******************************************
;*   DrawBoard: Draws an empty board      *
;*   input : NONE                         *
;*   output: NONE                         *
;******************************************
proc DrawBoard
    pusha
    mov cx, 7
   
EACH_ROW:
    push cx
    mov cx, 5
EACH_COL:
    mov bx, offset msg
    push bx
    mov ah, row
    mov al, col
    push ax
    call Particle
    add col, 12
    loop EACH_COL
    add row, 12            
    mov col, 112
    pop cx
    LOOP each_row
    popa
    ret
endp DrawBoard
 
;*****************************************************************
;*   AppleSpawner: Spawns an Apple in a random Col on the board  *
;*   input : NONE                                                *
;*   output: NONE                                                *                                                                                
;*****************************************************************
proc AppleSpawner
    pusha    
    mov bx,offset Apple
    push bx
    cmp Plz,0
    jnz Next
     
    Once:
    call DrawaNum
    mov al,12
    mul dl  
    add col,al
    inc Plz
    jmp Next
   
    Next:
    mov dx,ax
    xor ax,ax
    mov ah,Arow
    mov al,col
    push ax
    call Particle    
    popa      
    ret
endp AppleSpawner

;****************************************************************
;   BladeSpawner: Spawns a Blade in a random col on the board   * 
;   input :NONE                                                 *
;   output:NONE                                                 *
;****************************************************************
Proc BladeSpawner
    pusha
    mov bx,offset Dagger
    push bx
    cmp Wut,0
    jnz Next2
     
    Once2:
    call DrawaNum
    mov al,12
    mul dl  
    add Bcol,al
    inc Wut
    jmp Next2
   
    Next2:
    mov dx,ax
    xor ax,ax
    mov ah,Brow
    mov al,Bcol
    push ax
    call Particle                
    popa
    ret
endp BladeSpawner 
;****************************************************
;*   DrawaNum: draws a random number btw 0-4        *
;*   input : NONE                                   *
;*   output: puts in dl a number btw 0-4            *
;****************************************************
proc DrawaNum                
RANDSTART:
   MOV AH, 00h         
   INT 1AH       
   mov  ax, dx
   xor  dx, dx
   mov  cx, 5    
   div  cx      
   mov Num, dl
ret
endp DrawaNum
 
;******************************************************
;*  Player: draws a player character under the board  *
;*  input : NONE                                      *
;*  output: NONE                                      *
;******************************************************
proc Player
    pusha
    mov bx,offset Mouth
    push bx
    mov ah,Prow
    mov al,Pcol
    push ax
    call Particle  
    popa
    ret
endp Player
 
;************************************
;*  ClearP: clears last mouth       *
;*  input : NONE                    *
;*  output: NONE                    *
;************************************
proc ClearP
    pusha
    mov bx,offset ClearM
    push bx
    mov ah,Prow
    mov al,Pcol
    push ax
    call Particle    
    popa
    ret
endp ClearP
 
;******************************************
;*     MoveRight: moves mouth right       *
;*     input : a/d key                    *
;*     output: NONE                       *
;******************************************
proc Move
    pusha
     
    Fail:
    mov ah,1
    int 16h    
    cmp al,64h
    jnz Fail2
    call ClearP
    add Pcol,12  
    cmp Pcol,160
    ja bug1
    jmp mover
   
    Fail2:      
    cmp al,61h
    jnz end_move  
    Call ClearP
    sub Pcol,12
    cmp Pcol,112
    jb bug2
    jmp movel  
     
    bug1:
    mov Pcol,160
    jmp mover
   
    bug2:
    mov Pcol,112  
    jmp movel
   
    movel:
    call Player  
    
    mover:
    call Player    
  end_move:  
    mov ah,0ch
    mov al,0
    int 21h
    popa
    ret
endp Move                                          
 
;***************************************  
;*  AppleDown: moves apple down        *
;*  input : Apple row,Num              *
;*  output: NONE                       *
;***************************************
 
proc AppleDown
pusha
mov bx, offset wait_time
mov si, offset double_wait
inc [bx]
mov al, 0Fh
xor ah,ah
cmp [bx], ax 
jz down_once
jmp end_down
         
down_once:
inc [si]
mov al, 0Ah
add ah, 0
cmp [si], ax
jz down_real
jmp end_down
 
down_real:
mov bx, offset wait_time
mov si, offset double_wait
mov [bx], 0
mov [si], 0
call ClearA
add Arow,12
call AppleSpawner
end_down:
popa
ret
endp AppleDown

;***************************************  
;*  BladeDown: moves apple down        *
;*  input : Apple row,Num              *
;*  output: NONE                       *
;***************************************
 
proc BladeDown
pusha
mov bx, offset wait_time
mov si, offset double_wait
inc [bx]
mov al, 0FH
xor ah,ah
cmp [bx], ax 
jz down_once2
jmp end_down2
         
down_once2:
inc [si]
mov al, 5h
add ah, 0
cmp [si], ax
jz down_real2
jmp end_down2
 
down_real2:
mov bx, offset wait_time
mov si, offset double_wait
mov [bx], 0
mov [si], 0 
call ClearB
add Brow,12
call BladeSpawner 
end_down2:
popa
ret
endp BladeDown

;***************************************  
;*  BlankDown: Delays the game         *
;*  input : NONE                       *
;*  output: NONE                       *
;***************************************
 
proc BlankDown
pusha
mov bx, offset wait_time
mov si, offset double_wait
inc [bx]
mov al, 0FFH
add ah,0FFH
cmp [bx], ax 
jz down_once3
jmp end_down3
         
down_once3:
inc [si]
mov al, 0FFH
add ah, 0H
cmp [si], ax
jz down_real3
jmp end_down3
 
down_real3:
mov bx, offset wait_time
mov si, offset double_wait
mov [bx], 0
mov [si], 0  
end_down3:
popa
ret
endp BlankDown

;************************************
;*  ClearA: clears last apple       *
;*  input : NONE                    *
;*  output: NONE                    *
;************************************
proc ClearA
    pusha
    mov bx,offset msg
    push bx
    mov al,12
    add col,al
    sub col,12
    mov ah,Arow
    mov al,col
    push ax
    call Particle    
    popa
    ret
endp ClearA

;************************************
;*  ClearB: clears last blade       *
;*  input : NONE                    *
;*  output: NONE                    *
;************************************
proc ClearB
    pusha
    mov bx,offset msg
    push bx
    mov al,12
    add Bcol,al
    sub Bcol,12
    mov ah,Brow
    mov al,Bcol
    push ax
    call Particle    
    popa
    ret
endp ClearB
;************************************
;*  ClearBB: clears last blade      *
;*  input : NONE                    *
;*  output: NONE                    *
;************************************
proc ClearBB
    pusha
    mov bx,offset ClearM
    push bx
    mov al,12
    add Bcol,al
    sub Bcol,12
    mov ah,Brow
    mov al,Bcol
    push ax
    call Particle    
    popa
    ret
endp ClearBB
;***********************************************************
;*  ABM:calls at a time for Move BladeDown and AppleDown   *
;***********************************************************
Proc ABM
pusha
call Appledown
call Bladedown
call Move
popa
ret
endp ABM 

;****************************************************************************
;*  Defeat: checks for apple in the last row and compares it to the mouth   *
;*  if col do not match its defeat                                          *
;*  input : Pcol,Acol,Acol                                                  *
;*  output: if defeat confirmed returns a message                           *
;****************************************************************************
proc Defeat
    pusha
    cmp Arow,96
    jnz Check2
    jz Check

   
    Check:
    mov al,Pcol
    cmp col,al
    jnz Lose  
    jz Ok
    
    Check2:
    cmp Brow,96
    jnz Exit
    jz Check3
    
    Check3:
    mov al,Pcol
    cmp Bcol,al 
    jz Lose   
    jnz Ok2
    
    
    Win:
    lea dx,msg4
    mov ah,9
    int 21h
    jmp end
    
    Lose:
    lea dx,msg2 
    mov ah,9
    int 21h
    mov ah,0
    int 16h 
    lea dx,msg3 
    mov ah,9
    int 21h
    jmp end
            
    Ok:
    call Player
    mov Arow,12
    dec Plz
    mov col,112  
    inc Points 
    cmp Points,30 
    jz Win 
    call AppleSpawner 
    jmp Check2
    
    Ok2:
    call ClearBB
    mov Brow,12
    mov Wut,0
    mov Bcol,112   
    jz Win 
    call BladeSpawner
    
    Exit:  
    popa
    ret
endp Defeat 
start:   
  mov ax, data
  mov ds, ax 
  call init_graphics       
  call Opening_Screen
  mov ah,0
  int 16h
  jmp Game
  
  Game:
  mov ah,1
  int 16h
  call init_graphics
  call DrawBoard
  call AppleSpawner
  call Player
  Play:
  call Move    
  call AppleDown
  cmp Arow,12
  jz FFS
  cmp Arow,24  
  jz FFS
  jnz Now
  jmp Play
  
  FFS:
  call BlankDown
  jmp Play
  
  Now:
  call BladeSpawner
  call ABM
  jmp Continue
  
  Continue:  
  call Defeat  
  jmp Now
   
  End:
  mov Arow,12
  mov Brow,12
  mov Bcol,112
  mov col,112
  mov row,12
  mov Pcol,136
  mov Points,0 
  xor ax,ax
  mov ah,0
  int 16h 
  cmp al,79h
  jz start       
mov ax, 4c00h
int 21h  
ends 
end start ; set entry point and stop the assembler