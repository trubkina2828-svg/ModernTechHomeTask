# Консольное приложение электронной коммерции 



## Цель работы

Спроектировать и реализовать **консольное** приложение магазина, демонстрирующее объектно-ориентированный дизайн на современном Java. Типы данных реализуются **с нуля**. В методе `main` создаются объекты и показываются **несколько сценариев оплаты** с использованием паттерна **«Стратегия»** для провайдеров платежей.

---
Группа: ПИ24-2В

Команда: Трубкина+Штоликова

Студенты:
1. Трубкина Н.А. — порядковый номер в группе: 15
2. Штоликова Д.К. — порядковый номер в группе: 18


---
## Результаты сдачи

1. **ERD** сущности, атрибуты, связи (cardinality). Инструменты: draw.io, Lucidchart, PlantUML. Формат **PNG** или **PDF**.
2. **Исходный код**  полный проект; запуск из IntelliJ или командой `java` с указанием classpath.
3. **README.md**   описание, запуск в IntelliJ, **ФИО и роли** участников, ключевые решения, **скриншот** работы в консоли.

---

## Функциональные требования (консоль)

| Функция | Описание |
|--------|----------|
| Product catalog | List products with **category**, **price**, **stock** |
| Shopping cart | Add / remove lines; **total with VAT** |
| Order | Create order **from cart**; show order details |
| Payments | Pay through **Ozon** or **Wildberries** with a **PaymentMethod** |
| Order status | Show **status changes** (e.g. after checkout / updates) |


## Чек-лист студента

- [ ] ERD подготовлена и отражена в материалах сдачи  
- [ ] Все требуемые типы и пакеты присутствуют  
- [ ] Использованы records, sealed `PaymentMethod`, перечисления, `ArrayList`, `HashMap`  
- [ ] Реализованы `Payment`, `OzonPayment`, `WildberriesPayment` (Стратегия)  
- [ ] Проект компилируется и запускается; в README есть **скриншот**  
- [ ] Указаны **группа**, **команда**, **ФИО**, **порядковые номера** в письме и README  
- [ ] Сдано **до дедлайна**  

---
## Результаты работы
Скриншоты: 

https://github.com/trubkina2828-svg/ModernTechHomeTask/blob/main/res1.png

https://github.com/trubkina2828-svg/ModernTechHomeTask/blob/main/res2.png

https://github.com/trubkina2828-svg/ModernTechHomeTask/blob/main/res3.png

ERD:

https://github.com/trubkina2828-svg/ModernTechHomeTask/blob/main/erd.drawio.png
