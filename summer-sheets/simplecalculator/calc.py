"""This program will run simple calculations."""

import calc_functions

# Introduce program
print('Welcome to the Simple Calculator!')
print('')
print('In this program, you don\'t have to select options. It just determines')
print('what kind of equation you have typed in, and solves it! There are a few rules:')
print('')
print('- This program will only solve for binomial (2 part) equations.')
print('- Basic equations: Add(+), Subtract(-), Multiply(*), Divide(/)')
print('- To solve for a power, use \'**\' before the exponent. Convert roots to exponents.')
print('- To solve for remainder, use \'//\'.')
print('- All solutions are rounded to 8 digits after the decimal.')

#Main loop
loop = 'y'
while loop.lower() == 'y':
  print("")
  print("Please enter your equation below:")
  equation = input()
  print("")
  print(calc_functions.equation_id(equation))
  print("")

  # Exit loop
  while True:
    loop = (input("Would you like to solve another equation? (Y/N) "))[0]
    if not ((loop.lower() == 'y') or (loop.lower() == 'n')):
      print("Sorry, that is in an invalid input. Please try again.")
      print("")
      continue
    else:
      break
    