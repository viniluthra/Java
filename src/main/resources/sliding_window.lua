local total = 0
for i, key in ipairs(KEYS) do
    total = total + (tonumber(redis.call("get", key)) or 0)
end

if total >= tonumber(ARGV[2]) then
    return 0
end

redis.call("incr", ARGV[1])
redis.call("expire", ARGV[1], tonumber(ARGV[3]))
return 1
