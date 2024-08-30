import hashlib
import bisect

class ConsistentHashing:
    def __init__(self, servers=None, replicas=3):
        self.replicas = replicas
        self.ring = dict()
        self.sorted_keys = []

        if servers:
            for server in servers:
                self.add_server(server)

    def _hash(self, key):
        return int(hashlib.md5(key.encode('utf-8')).hexdigest(), 16)

    def add_server(self, server):
        for i in range(self.replicas):
            key = self._hash(f'{server}-{i}')
            self.ring[key] = server
            bisect.insort(self.sorted_keys, key)

    def remove_server(self, server):
        for i in range(self.replicas):
            key = self._hash(f'{server}-{i}')
            del self.ring[key]
            self.sorted_keys.remove(key)

    def get_server(self, key):
        if not self.ring:
            return None

        hash_key = self._hash(key)
        idx = bisect.bisect(self.sorted_keys, hash_key)
        if idx == len(self.sorted_keys):
            idx = 0
        return self.ring[self.sorted_keys[idx]]

# Example usage
if __name__ == "__main__":
    servers = ['http://server1.com', 'http://server2.com', 'http://server3.com']
    ch = ConsistentHashing(servers)

    # Example requests
    requests = ['request1', 'request2', 'request3', 'request4', 'request5']

    for req in requests:
        server = ch.get_server(req)
        print(f"Request {req} is mapped to server {server}")
