for i in range(0, 5):
    for j in range(0, 5):
        if (i == j):  # evita a inserção de laços no grafo
            continue
        print(i, j, end="\n")
