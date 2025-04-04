import json
import re
from datetime import datetime

def process_questions(content):
    qa_pairs = []
    question_pattern = re.compile(r"^####\s*(\d+)\)\s*(.+?)\s*\[\[src\]")
    current_question = None
    current_answer = []
    
    for line in content.split('\n'):
        line = line.strip()
        
        # Skip empty lines and metadata lines
        if not line or line.startswith('Current Date') or line.startswith('Current User') or line == '## Questions':
            continue
            
        # Check for new question
        question_match = question_pattern.match(line)
        if question_match:
            # Save previous question-answer pair if exists
            if current_question and current_answer:
                qa_pairs.append({
                    "question_number": int(current_question[0]),
                    "question": current_question[1],
                    "answer": " ".join(current_answer).strip()
                })
            
            # Start new question
            current_question = (question_match.group(1), question_match.group(2))
            current_answer = []
        elif line.startswith('[[Answer]]'):
            # Skip the [[Answer]] line itself
            continue
        elif current_question:
            # Skip markdown links at the end of answers
            if not line.startswith('[[src]]'):
                current_answer.append(line)
    
    # Add the last question-answer pair
    if current_question and current_answer:
        qa_pairs.append({
            "question_number": int(current_question[0]),
            "question": current_question[1],
            "answer": " ".join(current_answer).strip()
        })
    
    return qa_pairs

# Example usage:
if __name__ == "__main__":
    with open(r"D:\Interview-Simulator\Questions.md", "r", encoding="utf-8") as file:
        content = file.read()
    
    qa_pairs = process_questions(content)
    
    # Save to JSON
    with open("interview_questions.json", "w", encoding="utf-8") as json_file:
        json.dump(qa_pairs, json_file, indent=4, ensure_ascii=False)
    
    print("Processed successfully! Found {} questions.".format(len(qa_pairs)))