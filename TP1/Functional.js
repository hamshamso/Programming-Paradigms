import readline from 'readline' ;

const questions = [
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
];

const countTrueInRange = (answers, start, end) => {
    return answers.slice(start, end + 1).filter(Boolean).length;
};

const decidePersonality = (answers) => {
    const extrovertScore = countTrueInRange(answers, 0, 4);
    const introvertScore = countTrueInRange(answers, 5, 9);

    if (extrovertScore > introvertScore) {
        return "You're Extrovert";
    } else if (introvertScore > extrovertScore) {
        return "You're Introvert";
    } else {
        return "Balanced (Ambivert)";
    }
};

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const askQuestions = (index, accumulatedAnswers) => {
    if (index >= questions.length) {
        rl.close();
        const result = decidePersonality(accumulatedAnswers);
        console.log("\n" + result);
        return;
    }

    rl.question(`Q${index + 1}: ${questions[index]} (T/F): `, (answer) => {
        const isTrue = answer.trim().toUpperCase() === 'T' || answer.trim().toUpperCase() === 'Y';
        const newAnswers = [...accumulatedAnswers, isTrue];
        askQuestions(index + 1, newAnswers);
    });
};

askQuestions(0, []);