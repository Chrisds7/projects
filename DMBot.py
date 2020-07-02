from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import os

class AutoDM:
    
    def __init__(self):
        script_path = os.path.abspath(__file__) 
        path_list = script_path.split(os.sep)
        script_directory = path_list[0:len(path_list)-1]
        rel_path1 = "demofile.txt"
        rel_path2 = "chromedriver.exe"
        path2 = "/".join(script_directory) + "/" + rel_path2
        path1 = "/".join(script_directory) + "/" + rel_path1
        i = 0
        arr = []
        f = open(path1, "r")
        line = f.readline()
        arr.append(line)
        for line in f:
            arr.append(line)
        self.bot = webdriver.Chrome(path2)
        bot = self.bot
        bot.get("https://www.instagram.com/")
        time.sleep(1)
        username = bot.find_element_by_name("username")
        username.click()
        username.send_keys('username/email')
        password = bot.find_element_by_name("password")
        password.click()
        password.send_keys("password")
        bot.find_element_by_xpath("//*[@id='react-root']/section/main/article/div[2]/div[1]/div/form/div[4]/button/div").click()
        time.sleep(3)
        bot.find_element_by_class_name("xWeGp").click()
        time.sleep(1)
        bot.find_element_by_xpath("/html/body/div[4]/div/div/div/div[3]/button[2]").click()
        time.sleep(1)
        # dm button is the button to search once you are in the DM, step1
        dmButton = bot.find_element_by_xpath("//*[@id='react-root']/section/div/div[2]/div/div/div[1]/div[1]/div/div[3]/button")
        dmButton.click()
        # search is the search box when looking to DM a person, step2
        search = bot.find_element_by_name('queryBox')
        search.send_keys(arr[i])
        time.sleep(2)
        # target is the person you are clicking on, the actual string is in the array, step3
        target = bot.find_element_by_css_selector("body > div.RnEpo.Yx5HN > div > div > div.Igw0E.IwRSH.eGOV_.vwCYk.i0EQd > div.Igw0E.IwRSH.eGOV_.vwCYk._3wFWr > div > div > div.Igw0E.rBNOH.YBx95.ybXk5._4EzTm.soMvl > button > span")
        target.click()
        # nextButton is to go into the DM box to start typing, step4
        nextButton = bot.find_element_by_xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/button")
        nextButton.click()
        time.sleep(2)
        # messageButton is so you can write a message, step5
        messageButton = bot.find_element_by_xpath("//*[@id='react-root']/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/textarea")
        messageButton.click()
        messageButton.send_keys("Emily is gay")
        # send button is the button that sends the message inside the DM, step6
        sendButton = bot.find_element_by_xpath("//*[@id='react-root']/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[3]/button")
        sendButton.click()
        i = i + 1
        while i < len(arr):
            step1 = bot.find_element_by_xpath("//*[@id='react-root']/section/div/div[2]/div/div/div[1]/div[1]/div/div[3]/button")
            step1.click()
            step2 = bot.find_element_by_name("queryBox")
            step2.send_keys(arr[i])
            step2.click()
            time.sleep(2)
            step3 = bot.find_element_by_css_selector("body > div.RnEpo.Yx5HN > div > div > div.Igw0E.IwRSH.eGOV_.vwCYk.i0EQd > div.Igw0E.IwRSH.eGOV_.vwCYk._3wFWr > div > div > div.Igw0E.rBNOH.YBx95.ybXk5._4EzTm.soMvl > button > span")
            step3.click()
            step4 = bot.find_element_by_xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/div/button")
            step4.click()
            time.sleep(2)
            step5 = bot.find_element_by_xpath("//*[@id='react-root']/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/textarea")
            step5.click()
            step5.send_keys("Emily is homo")
            step6 = bot.find_element_by_xpath("//*[@id='react-root']/section/div/div[2]/div/div/div[2]/div[2]/div/div[2]/div/div/div[3]/button")
            step6.click()
            i = i + 1
            
example = AutoDM()