# Test_project_for_IBA
Чтобы запустить програму нужно скачать jar файл проекта в папке target. 
Запускать командой: java -jar TestProject-1.0.jar key data
Использование ключей: 
  1) -f <file path> - использовать абсолютный путь или положить в папку где находится jar. Если вы используете абсолютный в пути не должно 
  быть пробела(программа не найдет файл). 
  Пример: java -jar TestProject-1.0.jar -f [text.txt | C:..\..\..\text.txt]
  2) -cmd <command> - вы можете написать много команд(только с абсолютным путем). 
  Пример: java -jar TestProject-1.0.jar -сmd [cd D:..\..\.. dir | tree]
  3) -rk <path key> <key> - сначала полный путь к ключу, потом через пробел имя ключа.
  Пример: java -jar TestProject-1.0.jar -rk HKLM\SOFTWARE\Microsoft\AMSI FeatureBits
