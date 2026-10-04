import System.IO (hFlush, stdout)
import Data.Char (toUpper)

questions :: [String]
questions = [
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
  ]

countTrueInRange :: [Bool] -> Int -> Int -> Int
countTrueInRange answers start end = 
    length $ filter id (take (end - start + 1) (drop start answers))

decidePersonality :: [Bool] -> String
decidePersonality answers =
    let extrovertScore = countTrueInRange answers 0 4
        introvertScore = countTrueInRange answers 5 9
    in if extrovertScore > introvertScore
       then "You're Extrovert"
       else if introvertScore > extrovertScore
       then "You're Introvert"
       else "Balanced (Ambivert)"

askQuestions :: [String] -> IO [Bool]
askQuestions [] = return []
askQuestions (q:qs) = do
    putStr (q ++ " (T/F): ")
    hFlush stdout
    input <- getLine
    let cleanedInput = map toUpper (filter (/= ' ') input)
        ans = cleanedInput == "T" || cleanedInput == "Y"
    rest <- askQuestions qs
    return (ans : rest)

main :: IO ()
main = do
    answers <- askQuestions questions
    putStrLn ""
    putStrLn (decidePersonality answers)