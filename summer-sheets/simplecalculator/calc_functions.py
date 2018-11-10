"""This program contains the equations for Simple Calculator.

Arguments:
  equation: the equation string entered by the user

Returns:
  The solution in a completed text statement.
  error_message: an error message due to bad user data (if applicable)"""

def equation_id(equation):
  """This function determines which kind of equation has been entered.
  
  It analyses the equation with each possible operator to find a match. It then isolates the numbers
  and sends them to the corresponding functions. These functions return the solution, and this function
  returns that to the main method."""

  # Strips spaces and commas from entry
  equation = equation.replace(' ','')
  equation = equation.replace(',','')

  # Error message if equation input is invalid
  error_message = 'The solution cannot be calculated due to an invalid input.'
  
  # This dictionary includes the symbols, and the tuple holds lambdas.
  symbols = {0:'+', 1:'-', 2:'**', 3:'/', 4:'*'}
  functions = (
    (lambda num1,num2: num1 + num2),
    (lambda num1,num2: num1 - num2),
    (lambda num1,num2: num1 ** num2),
    (lambda num1,num2: num1 / num2),
    (lambda num1,num2: num1 * num2)
  )
  
  # Checks if question is remainder 
  if equation[1:].find('//') != -1:
    
    # isolates numbers and converts to float
    try:
      num1, num2 = equation.split('//')
      num1 = float(num1)
      num2 = float(num2)
    except ValueError:
      return error_message

    # Calculate quotient and remainder
    quotient = num1 // num2
    remainder = num1 % num2

    #Format the solution
    return 'The quotient is {} and the remainder is {:.8f}.'.format(int(quotient),remainder)

  # Iterates through possible equations except remainder
  for s in symbols:
    if equation[1:].find(symbols[s]) != -1: # An operator has been located (avoids first character due to negatives)
      
      # Isolates the numbers and converts to float
      try:
        num1, num2 = equation.split(symbols[s])
        num1 = float(num1)
        num2 = float(num2)
      except ValueError:
        return error_message

      # Calculate solution and format
      return 'The solution is {:.8f}.'.format(functions[s](num1,num2))
  return error_message