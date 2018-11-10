file = open("append-text-ex/HelloThere.txt", "a")
for r in range(5):
  file.write('General Kenobi!\n')
file.close()
del file
file = open("append-text-ex/HelloThere.txt", "r")
print(file.read())
file.close