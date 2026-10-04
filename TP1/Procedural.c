#include <stdio.h>
#include <stdbool.h>

int main() {
    const char *Q[10] = {
        "I enjoy going to parties with lots of people.",
        "I find it easy to start conversations with strangers.",
        "I feel comfortable being the center of attention.",
        "I prefer working in a group rather than alone.",
        "I feel more energized after spending time with other people.",
        "I feel more energized after spending time alone.",
        "I prefer listening over talking in group discussions.",
        "I need quiet time to recharge after socializing.",
        "I prefer a quiet night in over a big social event.",
        "I think carefully before speaking in a group."
    };

    bool A[10];
    int X = 0, I = 0;
    int i;
    char input;

    for (i = 0; i < 5; i++) {
        printf("Q%d: %s (T/F): ", i + 1, Q[i]);
        scanf(" %c", &input);
        
        if (input == 'T' || input == 't'|| input == 'y'|| input == 'Y') {
            A[i] = true;
            X++;
        } else {
            A[i] = false;
        }
    }

    for (i = 5; i < 10; i++) {
        printf("Q%d: %s (T/F): ", i + 1, Q[i]);
        scanf(" %c", &input);
        
        if (input == 'T' || input == 't'|| input == 'y'|| input == 'Y') {
            A[i] = true;
            I++; 
        } else {
            A[i] = false;
        }
    }

    if (X > I) {
        printf("\nYou're Extrovert\n");
    } else if (I > X) {
        printf("\nYou're Introvert\n");
    } else {
        printf("\nBalanced (Ambivert)\n");
    }

    return 0;
}