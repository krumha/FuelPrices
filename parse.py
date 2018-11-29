import requests
from bs4 import BeautifulSoup
import re
import sqlite3
def get_price (rexp, s):
	rez = re.findall(rexp, s)
	if rez == []:
		return ''
	else:
		rexp = r' [\d.]+'
		rez = re.findall(rexp, rez[0])
		if rez == []:
			return ''
		else:
			return rez[0].strip()

def get_html():
	url = 'https://russiabase.ru/prices.php?region=39'
	r = requests.get(url)
	return r.text

def get_data(html):
	soup = BeautifulSoup(html, 'lxml')
	azss = soup.findAll('div', class_='org-pane')
	conn = sqlite3.connect('benz.db')
	c = conn.cursor()
	c.execute("DELETE FROM benz_main")
	conn.commit()
	for azs in azss:
		name = azs.find('div', class_='org-head').get_text()
		body = azs.find('div', class_='org-body').get_text().split('Цены:')
		adress = body[0]
		price = body[1]
		ai80 = get_price(r'Аи80[\d .-]+', price)
		ai92 = get_price(r'Аи92[\d .-]+', price)
		ai92_plus = get_price(r'Аи92\+[\d .-]+', price)
		ai95 = get_price(r'Аи95[\d .-]+', price)
		ai95_plus = get_price(r'Аи95\+[\d .-]+', price)
		ai98 = get_price(r'Аи98[\d .-]+', price)
		ai98_plus = get_price(r'Аи98\+[\d .-]+', price)
		ai100 = get_price(r'Аи100[\d .-]+', price)
		ai100_plus = get_price(r'Аи100\+[\d .-]+', price)
		ai_DT = get_price(r'Дизель[\d .-]+', price)
		ai_DT_plus = get_price(r'Дизель\+[\d .-]+', price)
		ai_Propan = get_price(r'Пропан[\d .-]+', price)
		ai_Metan = get_price(r'Метан[\d .-]+', price)
		c.execute("INSERT INTO benz_main ( name_azs,ai_80,ai_92,ai_92_plus,ai_95,ai_95_plus,ai_98,ai_98_plus,ai_100,ai_100_plus,ai_DT,ai_DT_plus,ai_Propan,ai_Metan,Adress)VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')"%(name, ai80, ai92, ai92_plus, ai95, ai95_plus, ai98, ai98_plus, ai100, ai100_plus, ai_DT, ai_DT_plus, ai_Propan, ai_Metan, adress))	
		conn.commit()
	c.close()
	conn.close()

def main():
	get_data(get_html())

if __name__ == '__main__':
	main()