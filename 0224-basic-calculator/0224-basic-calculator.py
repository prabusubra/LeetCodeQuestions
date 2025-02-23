class Solution:
    def calculate(self, s: str) -> int:
        stack = []

        curr_sum, sign, res = 0, 1, 0

        for c in s:

            if c.isdigit():
                curr_sum = curr_sum*10 + int(c)

            elif c =='+' or c == '-':
                res += curr_sum * sign
                sign = -1 if c == '-' else 1
                curr_sum = 0
            
            elif c == '(':
                stack.append(res)
                stack.append(sign)
                res, sign = 0, 1
            elif c == ')':

                res += sign * curr_sum

                res *= stack.pop()
                res += stack.pop()
                curr_sum = 0
                
        return res + curr_sum * sign