# from selenium import webdriver
# from selenium.webdriver.chrome.service import Service
# from webdriver_manager.chrome import ChromeDriverManager
# from selenium.webdriver.common.by import By
# import time
# import pandas as pd

# # Set up Chrome browser with undetected mode
# options = webdriver.ChromeOptions()
# options.add_argument("--headless")  # Run in the background
# options.add_argument("--no-sandbox")
# options.add_argument("--disable-blink-features=AutomationControlled")

# # Initialize WebDriver
# driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)

# # URL to scrape
# url = "https://www.sanfoundry.com/cplusplus-interview-questions-answers/"
# driver.get(url)

# # Wait for JavaScript to load
# time.sleep(5)

# # Extract questions
# questions = driver.find_elements(By.TAG_NAME, "h2")  # Modify if needed
# question_list = [q.text.strip() for q in questions]

# # Save to CSV
# df = pd.DataFrame({"Question": question_list})
# df.to_csv("cpp3_interview_questions.csv", index=False)

# print("Scraping complete! Data saved to cpp_interview_questions.csv")

# # Close the browser
# driver.quit()


from requests_html import HTMLSession

session = HTMLSession()
url = "https://www.sanfoundry.com/cplusplus-interview-questions-answers/"

response = session.get(url)
response.html.render(sleep=3)  # Renders JavaScript

questions = response.html.find("h2")  # Adjust selector if needed
question_list = [q.text.strip() for q in questions]

print(question_list)
