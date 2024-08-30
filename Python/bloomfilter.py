import hashlib
class BloomFilter:

    def __init__(self, size, hash_count):
        self.size = size
        self.hash_count = hash_count
        self.bit_array = [0] * size

    def hashes(self, item):
        hashes = []
        item = item.encode('utf-8')
        for i in range(self.hash_count):
            hash_result = int(hashlib.md5(item + str(i).encode('utf-8')).hexdigest(), 16)
            hashes.append(hash_result % self.size)
        return hashes
    
    def add(self, item):
        for index in self.hashes(item):
            self.bit_array[index] = 1

    def check(self, item):
        """Check if an item is possibly in the bloom filter."""
        for index in self.hashes(item):
            if self.bit_array[index] == 0:
                return False
        return True
    
bloom = BloomFilter(size=1000, hash_count=3)

# Adding elements to the filter
bloom.add("apple")
bloom.add("banana")
bloom.add("grape")

# Checking elements
print(bloom.check("apple"))  # Output: True
print(bloom.check("banana"))  # Output: True
print(bloom.check("grape"))  # Output: True
print(bloom.check("orange"))  # Output: False (definitely not in the set)
print(bloom.check("cherry"))  # Output: False (definitely not in the set)

# False positive example
bloom.add("kiwi")
print(bloom.check("kiwi"))


