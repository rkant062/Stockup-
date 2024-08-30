class Parent1:
    def fun1(self):
        print("Parent1's fun1 method")

    def fun2(self):
        print("Parent1's fun2 method")

class Parent2:
    def fun1(self):
        print("Parent2's fun1 method")

    def fun2(self):
        print("Parent2's fun2 method")

class Child(Parent1, Parent2):
    def fun1(self):
        # Directly call Parent1's fun1 then Parent2's fun1
        Parent1.fun1(self)
        Parent2.fun1(self)

    def fun2(self):
        # Directly call Parent2's fun2 then Parent1's fun2
        Parent2.fun2(self)
        Parent1.fun2(self)

# Creating an instance of Child
c = Child()

# Testing the methods
print("Calling c.fun1()")
c.fun1()  # Should print Parent1's fun1 then Parent2's fun1
print("Calling c.fun2()")
c.fun2()  # Should print Parent2's fun2 then Parent1's fun2
