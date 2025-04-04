import requests
from bs4 import BeautifulSoup
import pandas as pd

# URL of the site
url = "https://www.careerride.com/android-interview-questions.aspx"

# Send GET request with headers
headers = {"User-Agent": "Mozilla/5.0"}
response = requests.get(url, headers=headers)

# Parse the HTML
soup = BeautifulSoup(response.text, "html.parser")

# Find all divs containing questions and answers
qa_blocks = soup.find_all("div", class_="text")

# Extract questions and answers
data = []
for block in qa_blocks:
    question = block.find("h2").text.strip() if block.find("h2") else None
    answer = block.text.replace(question, "").strip() if question else block.text.strip()
    
    if question and answer:
        data.append({"Question": question, "Answer": answer})

# Save to CSV
df = pd.DataFrame(data)
df.to_json("android_interview_questions_answers.json", orient="records", indent=4, force_ascii=False)


print("Scraping complete! Data saved to android_interview_questions_answers.csv")
