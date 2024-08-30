# 1. List comprehension with conditionals
even_squares = [x**2 for x in range(10) if x % 2 == 0]
print("Even Squares:", even_squares)

# 2. Nested list comprehension to create a 3x3 identity matrix
identity_matrix = [[1 if i == j else 0 for j in range(3)] for i in range(3)]
print("3x3 Identity Matrix:")
for row in identity_matrix:
    print(row)

# 3. Dictionary comprehension to map numbers to their squares
squares_dict = {x: x**2 for x in range(5)}
print("Squares Dictionary:", squares_dict)

# 4. Set comprehension to create a set of squared values
squares_set = {x**2 for x in range(10)}
print("Squares Set:", squares_set)

# 5. Generator expression to create squares of numbers from 0 to 9
squares_gen = (x**2 for x in range(10))
print("Squares from Generator:", list(squares_gen))

# 6. Using zip in a list comprehension to pair elements from two lists
list1 = [1, 2, 3]
list2 = ['a', 'b', 'c']
paired = [(x, y) for x, y in zip(list1, list2)]
print("Paired Lists:", paired)

# 7. Flattening a 2D list into a 1D list using list comprehension
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
flattened = [item for sublist in matrix for item in sublist]
print("Flattened Matrix:", flattened)

# 8. Enumerate in list comprehension to create a list of indexed strings
indexed_strings = [f"{i}: {s}" for i, s in enumerate(['apple', 'banana', 'cherry'])]
print("Indexed Strings:", indexed_strings)

# 9. Lambda functions in list comprehension to increment each element
incremented = [(lambda x: x + 3)(x) for x in range(5)]
print("Incremented Values:", incremented)

# 10. Cartesian product of two lists using list comprehension
cartesian_product = [(x, y) for x in [1, 2, 3] for y in ['a', 'b', 'c']]
print("Cartesian Product:", cartesian_product)
