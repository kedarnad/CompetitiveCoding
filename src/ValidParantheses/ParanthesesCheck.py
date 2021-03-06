# Sid
class Solution:
    def isValid(self, s: 'str') -> 'bool':
        openList = ["[", "{", "("]
        closeList = ["]", "}", ")"]
        stack = []
        pos = 0
        if not s:
            return True
        for i in s:
            if i in openList:
                stack.append(i)
            elif i in closeList:
                pos = closeList.index(i)
                
                #Checking if the top of the stack matches the closing parantheses encountered, if yes then pop
                if ((len(stack) > 0) and (openList[pos] == stack[len(stack) - 1])):
                    stack.pop()
                else:
                    return False
        if len(stack) == 0:
            return True
        else:
            return False


obj = Solution()
print('Valid Parantheses:', obj.isValid('{}]'))
